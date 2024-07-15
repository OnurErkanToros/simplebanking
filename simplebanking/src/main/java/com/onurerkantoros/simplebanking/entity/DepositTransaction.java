package com.onurerkantoros.simplebanking.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("deposit")
public class DepositTransaction extends Transaction{
    public DepositTransaction() {
    }
    public DepositTransaction(double amount){
        super(amount);
    }
    public String getType(){
        return "DepositTransaction";
    }
}
