package com.onurerkantoros.simplebanking.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("bill_payment")
public class BillPaymentTransaction extends Transaction{
    private String provider;
    private String phoneNumber;
    public BillPaymentTransaction() {

    }
    public BillPaymentTransaction(String provider,String phoneNumber,double amount){
        super(amount);
        this.provider=provider;
        this.phoneNumber=phoneNumber;
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
    public String getType(){
        return "BillPaymentTransaction";
    }
}
