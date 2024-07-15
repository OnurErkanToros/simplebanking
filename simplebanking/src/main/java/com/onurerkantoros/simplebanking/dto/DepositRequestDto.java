package com.onurerkantoros.simplebanking.dto;

public class DepositRequestDto extends TransactionRequestDto{
    public DepositRequestDto() {
    }

    public DepositRequestDto(double amount) {
        super(amount);
    }
}
