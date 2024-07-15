package com.onurerkantoros.simplebanking.dto;

public class DepositResponseDto extends TransactionResponseDto{

    public DepositResponseDto() {
    }

    public DepositResponseDto(String status, String approvalCode) {
        super(status, approvalCode);
    }
}
