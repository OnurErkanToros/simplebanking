package com.onurerkantoros.simplebanking.dto;

public class PhoneBillPaymentRequestDto extends TransactionRequestDto{
    private String provider;
    private String phoneNumber;

    public PhoneBillPaymentRequestDto() {
    }

    public PhoneBillPaymentRequestDto(double amount, String provider, String phoneNumber) {
        super(amount);
        this.provider = provider;
        this.phoneNumber = phoneNumber;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
