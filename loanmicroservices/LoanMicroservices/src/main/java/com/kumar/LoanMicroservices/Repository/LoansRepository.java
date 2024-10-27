package com.kumar.LoanMicroservices.Repository;

import com.kumar.LoanMicroservices.Entities.Loans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoansRepository extends JpaRepository<Loans,Long> {

    Optional<Loans> findByMobileNumber(String mobileNumber);

    Optional<Loans> findByLoanNumber(String loanNumber);


}
