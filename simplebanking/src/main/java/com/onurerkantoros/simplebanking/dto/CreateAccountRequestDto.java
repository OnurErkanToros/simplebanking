package com.onurerkantoros.simplebanking.dto;

public class CreateAccountRequestDto {
    private String owner;
    private int accountNumber;

    public CreateAccountRequestDto() {
    }

    public CreateAccountRequestDto(String owner, int accountNumber) {
        this.owner = owner;
        this.accountNumber = accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
}
