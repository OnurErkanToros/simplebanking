package com.onurerkantoros.simplebanking.entity;

import com.onurerkantoros.simplebanking.exceptions.InsufficientBalanceException;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class BankAccount {
    @Id
    private String accountNumber;
    private String owner;
    private double balance;
    @OneToMany(mappedBy = "bankAccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Transaction> transactions;

    public BankAccount() {
    }

    public BankAccount(String owner, int accountNumber) {
        this.owner = owner;
        this.accountNumber = String.valueOf(accountNumber);
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public void post(Transaction transaction) throws InsufficientBalanceException {
        if (transaction == null) {
            throw new IllegalArgumentException("İşlem null olamaz");
        }

        if (transaction instanceof WithdrawalTransaction || transaction instanceof BillPaymentTransaction) {
            if (balance < transaction.getAmount()) {
                throw new InsufficientBalanceException(accountNumber, balance, transaction.getAmount());
            }
            balance -= transaction.getAmount();
        } else if (transaction instanceof DepositTransaction) {
            balance += transaction.getAmount();
        } else {
            throw new IllegalArgumentException("Desteklenmeyen işlem türü: " + transaction.getClass().getSimpleName());
        }
        transaction.setBankAccount(this);
        transactions.add(transaction);
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
