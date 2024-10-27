package com.kumar.AccountMicroservices.Repository;

import com.kumar.AccountMicroservices.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer,Long> {

    Optional<Customer> findByMobileNumber(String mobileNumber);

}
