package com.onurerkantoros.simplebanking.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("withdrawal")
public class WithdrawalTransaction extends Transaction{
    public WithdrawalTransaction() {
    }

    public WithdrawalTransaction(double amount) {
        super(amount);
    }
    public String getType(){
        return "WithdrawalTransaction";
    }
}
