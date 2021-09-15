package com.example.billingservice.exceptions;
//presonaliseé exception
public class CustomerNotFounException extends RuntimeException{
    public CustomerNotFounException(String message) {
        super(message);
    }
}
