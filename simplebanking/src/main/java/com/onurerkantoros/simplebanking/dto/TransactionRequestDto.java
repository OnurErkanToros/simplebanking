package com.onurerkantoros.simplebanking.dto;

public class TransactionRequestDto {
    private double amount;

    public TransactionRequestDto() {
    }

    public TransactionRequestDto(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
