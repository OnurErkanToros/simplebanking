package com.onurerkantoros.simplebanking.dto;

public class PhoneBillPaymentResponseDto extends TransactionResponseDto{
    public PhoneBillPaymentResponseDto() {
    }

    public PhoneBillPaymentResponseDto(String status, String approvalCode) {
        super(status, approvalCode);
    }
}
