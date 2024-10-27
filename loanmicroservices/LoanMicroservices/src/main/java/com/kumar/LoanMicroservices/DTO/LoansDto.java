package com.kumar.LoanMicroservices.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@Schema(name = "Loans",
        description = "Schema to hold Loan information"
)
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoansDto {

    @NotEmpty(message = "Mobile Number can not be a null or empty")
    @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile Number must be 10 digits")
    @Schema(
            description = "Mobile Number of Customer", example = "4365327698"
    )
    private String mobileNumber;

    @NotEmpty(message = "Loan Number can not be a null or empty")
    @Pattern(regexp="(^$|[0-9]{12})",message = "LoanNumber must be 12 digits")
    @Schema(
            description = "Loan Number of the customer", example = "548732457654"
    )
    private String loanNumber;

    @NotEmpty(message = "LoanType can not be a null or empty")
    @Schema(
            description = "Type of the loan", example = "Home Loan"
    )
    private String loanType;

    @Positive(message = "Total loan amount should be greater than zero")
    @Schema(
            description = "Total loan amount", example = "100000"
    )
    private int totalLoan;

    @PositiveOrZero(message = "Total loan amount paid should be equal or greater than zero")
    @Schema(
            description = "Total loan amount paid", example = "1000"
    )
    private int amountPaid;

    @PositiveOrZero(message = "Total outstanding amount should be equal or greater than zero")
    @Schema(
            description = "Total outstanding amount against a loan", example = "99000"
    )
    private int outstandingAmount;

    public @NotEmpty(message = "Mobile Number can not be a null or empty") @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number must be 10 digits") String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(@NotEmpty(message = "Mobile Number can not be a null or empty") @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number must be 10 digits") String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public @NotEmpty(message = "Loan Number can not be a null or empty") @Pattern(regexp = "(^$|[0-9]{12})", message = "LoanNumber must be 12 digits") String getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(@NotEmpty(message = "Loan Number can not be a null or empty") @Pattern(regexp = "(^$|[0-9]{12})", message = "LoanNumber must be 12 digits") String loanNumber) {
        this.loanNumber = loanNumber;
    }

    public @NotEmpty(message = "LoanType can not be a null or empty") String getLoanType() {
        return loanType;
    }

    public void setLoanType(@NotEmpty(message = "LoanType can not be a null or empty") String loanType) {
        this.loanType = loanType;
    }

    @Positive(message = "Total loan amount should be greater than zero")
    public int getTotalLoan() {
        return totalLoan;
    }

    public void setTotalLoan(@Positive(message = "Total loan amount should be greater than zero") int totalLoan) {
        this.totalLoan = totalLoan;
    }

    @PositiveOrZero(message = "Total loan amount paid should be equal or greater than zero")
    public int getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(@PositiveOrZero(message = "Total loan amount paid should be equal or greater than zero") int amountPaid) {
        this.amountPaid = amountPaid;
    }

    @PositiveOrZero(message = "Total outstanding amount should be equal or greater than zero")
    public int getOutstandingAmount() {
        return outstandingAmount;
    }

    public void setOutstandingAmount(@PositiveOrZero(message = "Total outstanding amount should be equal or greater than zero") int outstandingAmount) {
        this.outstandingAmount = outstandingAmount;
    }
}
