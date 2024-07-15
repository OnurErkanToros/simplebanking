package com.onurerkantoros.simplebanking.dto;

public class WithdrawRequestDto extends TransactionRequestDto{
    public WithdrawRequestDto() {
    }

    public WithdrawRequestDto(double amount) {
        super(amount);
    }
}
