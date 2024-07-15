package com.onurerkantoros.simplebanking.dto;

public class WithdrawResponseDto extends TransactionResponseDto{
    public WithdrawResponseDto() {
    }

    public WithdrawResponseDto(String status, String approvalCode) {
        super(status, approvalCode);
    }
}
