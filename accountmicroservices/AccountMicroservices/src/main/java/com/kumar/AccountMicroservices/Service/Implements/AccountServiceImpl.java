package com.kumar.AccountMicroservices.Service.Implements;

import com.kumar.AccountMicroservices.Constant.AccountConstants;
import com.kumar.AccountMicroservices.Dto.AccountsDto;
import com.kumar.AccountMicroservices.Dto.CustomerDto;
import com.kumar.AccountMicroservices.Entities.Accounts;
import com.kumar.AccountMicroservices.Entities.Customer;
import com.kumar.AccountMicroservices.Exeptions.CustomerAlreadyExistExceptions;
import com.kumar.AccountMicroservices.Exeptions.ResourceNotFoundException;
import com.kumar.AccountMicroservices.Mapper.AccountsMapper;
import com.kumar.AccountMicroservices.Mapper.CustomerMapper;
import com.kumar.AccountMicroservices.Repository.AccountsRepository;
import com.kumar.AccountMicroservices.Repository.CustomerRepository;
import com.kumar.AccountMicroservices.Service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;


@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    @Override
    public void CreateAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto , new Customer());
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if(optionalCustomer.isPresent()){
            throw  new CustomerAlreadyExistExceptions("Customer already exist with the mobile Number"+customerDto.getMobileNumber());
        }

        Customer Savecustomer = customerRepository.save(customer);
        accountsRepository.save(createNewAccount(Savecustomer));



    }



    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountConstants.SAVINGS);
        newAccount.setAccountAddress(AccountConstants.ADDRESS);

        return newAccount;
    }

    @Override
    public CustomerDto fetchAccountDetails(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer","mobileNumber",mobileNumber));

        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Accounts","customerId",customer.getCustomerId().toString())
        );

        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
        customerDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));
        return customerDto;


    }

    @Override
    public boolean updateAccount(CustomerDto customerDto) {
        boolean isUpdated = false;
        AccountsDto accountsDto = customerDto.getAccountsDto();
        if(accountsDto !=null ){
            Accounts accounts = accountsRepository.findById(accountsDto.getAccountNumber()).orElseThrow(
                    () -> new ResourceNotFoundException("Account", "AccountNumber", accountsDto.getAccountNumber().toString())
            );
            AccountsMapper.mapToAccounts(accountsDto, accounts);
            accounts = accountsRepository.save(accounts);

            Long customerId = accounts.getCustomerId();
            Customer customer = customerRepository.findById(customerId).orElseThrow(
                    () -> new ResourceNotFoundException("Customer", "CustomerID", customerId.toString())
            );
            CustomerMapper.mapToCustomer(customerDto,customer);
            customerRepository.save(customer);
            isUpdated = true;
        }
        return  isUpdated;
    }

    @Override
    public boolean deleteAccount(String mobileNum) {

        Customer customer = customerRepository.findByMobileNumber(mobileNum).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNum)
        );
        accountsRepository.deleteByCustomerId(customer.getCustomerId());
        customerRepository.deleteById(customer.getCustomerId());
        return true;


    }

}
