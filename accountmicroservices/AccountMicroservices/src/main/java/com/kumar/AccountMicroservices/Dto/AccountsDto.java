package com.kumar.AccountMicroservices.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        name = "Accounts",
        description = "Schema to hold account information"
)
public class AccountsDto {

    @NotEmpty(message = "Account Number should not be empty or Blank")
    @Pattern(regexp = "(^$|[0-9]{10})",message = "Account number should be of the pattern ")

    @Schema(

            description = "Account Number of Customer"
    )
    private Long accountNumber;

    @Schema(

            description = "Account type of Accounts",example = "Savings"
    )
    @NotEmpty(message = "Account Number should not be empty or Blank")
    private String accountType;


    @Schema(

            description = "Account Address of Accounts",example = "123 xyx ,Delhi "
    )
    @NotEmpty(message = "Account Number should not be empty or Blank")
    private String accountAddress;


    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountAddress() {
        return accountAddress;
    }

    public void setAccountAddress(String accountAddress) {
        this.accountAddress = accountAddress;
    }

}
