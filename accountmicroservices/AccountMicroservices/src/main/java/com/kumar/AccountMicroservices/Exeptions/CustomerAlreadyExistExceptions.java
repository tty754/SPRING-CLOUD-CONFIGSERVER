package com.kumar.AccountMicroservices.Exeptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CustomerAlreadyExistExceptions extends  RuntimeException{

    public CustomerAlreadyExistExceptions(String message) {
        super(message);
    }

}
