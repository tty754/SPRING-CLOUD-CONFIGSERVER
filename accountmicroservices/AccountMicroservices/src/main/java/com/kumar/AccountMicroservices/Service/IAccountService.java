package com.kumar.AccountMicroservices.Service;

import com.kumar.AccountMicroservices.Dto.CustomerDto;

public interface IAccountService {

    void CreateAccount(CustomerDto customerDto);
    CustomerDto fetchAccountDetails(String mobileNumber);
    boolean updateAccount(CustomerDto customerDto);
    boolean deleteAccount(String mobileNum);

}
