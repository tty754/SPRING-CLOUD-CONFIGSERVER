package com.kumar.AccountMicroservices.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = "Customer",
        description = "Schema to hold customer and account information"
)
public class CustomerDto {


    @Schema(

            description = "Name of the customer",
            example = "Kumar Karan"
    )
    @NotEmpty(message = "Name should not be empty or Blank")
    @Size(min = 5 ,max = 30 ,message = "Name length should be between 5 and 30")
    private String  name;

    @Schema(

            description = "Email address of the customer",
            example = "Kumar@gmail.com"
    )
    @NotEmpty(message = "Email should not be empty or Blank")
    @Email(message = "Email address be Valid Value")
    private String email;

    @Schema(

            description = "Mobile Number of the customer",
            example = "9610673984"
    )
    @NotEmpty(message = "Mobile Number should not be empty or Blank")
    @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile number should be of the pattern ")
    private String mobileNumber;

    private AccountsDto accountsDto;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public AccountsDto getAccountsDto() {
        return accountsDto;
    }

    public void setAccountsDto(AccountsDto accountsDto) {
        this.accountsDto = accountsDto;
    }

}
