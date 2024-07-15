package com.onurerkantoros.simplebanking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String accountNumber, double currentBalance, double requestedAmount) {
        super(String.format("Insufficient funds for account %s. Current balance: %.2f, Requested amount: %.2f",
                accountNumber, currentBalance, requestedAmount));
    }
}