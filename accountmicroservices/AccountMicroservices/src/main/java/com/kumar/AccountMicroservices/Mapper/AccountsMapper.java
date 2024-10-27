package com.kumar.AccountMicroservices.Mapper;

import com.kumar.AccountMicroservices.Dto.AccountsDto;
import com.kumar.AccountMicroservices.Entities.Accounts;

public class AccountsMapper {

    public static AccountsDto mapToAccountsDto(Accounts accounts, AccountsDto accountsDto) {
        accountsDto.setAccountNumber(accounts.getAccountNumber());
        accountsDto.setAccountType(accounts.getAccountType());
        accountsDto.setAccountAddress(accounts.getAccountAddress());
        return accountsDto;
    }

    public static Accounts mapToAccounts(AccountsDto accountsDto, Accounts accounts) {
        accounts.setAccountNumber(accountsDto.getAccountNumber());
        accounts.setAccountType(accountsDto.getAccountType());
        accounts.setAccountAddress(accountsDto.getAccountAddress());
        return accounts;
    }


}
