package com.onurerkantoros.simplebanking.services;

import com.onurerkantoros.simplebanking.dto.CreateAccountRequestDto;
import com.onurerkantoros.simplebanking.exceptions.AccountNotFoundException;
import com.onurerkantoros.simplebanking.exceptions.InsufficientBalanceException;
import com.onurerkantoros.simplebanking.entity.*;
import com.onurerkantoros.simplebanking.repository.BankAccountRepository;
import com.onurerkantoros.simplebanking.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class BankAccountService {
    private final BankAccountRepository bankAccountRepository;
    private final TransactionRepository transactionRepository;

    public BankAccountService(BankAccountRepository bankAccountRepository, TransactionRepository transactionRepository) {
        this.bankAccountRepository = bankAccountRepository;
        this.transactionRepository = transactionRepository;
    }
    @Transactional
    public BankAccount createAccount(CreateAccountRequestDto createAccountRequestDto) {
        BankAccount account =
                new BankAccount(createAccountRequestDto.getOwner(),createAccountRequestDto.getAccountNumber());
        return bankAccountRepository.save(account);
    }

    @Transactional
    public BankAccount deposit(String accountNumber, double amount) throws InsufficientBalanceException, AccountNotFoundException {
        validateAmount(amount);
        BankAccount account = getAccount(accountNumber);
        DepositTransaction transaction = new DepositTransaction(amount);
        transaction.setApprovalCode(generateApprovalCode());
        account.post(transaction);
        transactionRepository.save(transaction);
        return bankAccountRepository.save(account);
    }

    @Transactional
    public BankAccount withdraw(String accountNumber, double amount) throws InsufficientBalanceException, AccountNotFoundException {
        validateAmount(amount);
        BankAccount account = getAccount(accountNumber);
        WithdrawalTransaction transaction = new WithdrawalTransaction(amount);
        transaction.setApprovalCode(generateApprovalCode());
        account.post(transaction);
        transactionRepository.save(transaction);
        return bankAccountRepository.save(account);
    }

    @Transactional
    public BankAccount payPhoneBill(String accountNumber, String provider, String phoneNumber, double amount) throws InsufficientBalanceException, AccountNotFoundException {
        validateAmount(amount);
        BankAccount account = getAccount(accountNumber);
        BillPaymentTransaction transaction = new BillPaymentTransaction(provider, phoneNumber, amount);
        transaction.setApprovalCode(generateApprovalCode());
        account.post(transaction);
        transactionRepository.save(transaction);
        return bankAccountRepository.save(account);
    }

    public BankAccount getAccount(String accountNumber) throws AccountNotFoundException {
        return bankAccountRepository.findById(accountNumber)
                .orElseThrow(AccountNotFoundException::new);
    }

    private String generateApprovalCode() {
        return UUID.randomUUID().toString();
    }

    private void validateAmount(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("The amount must be positive");
        }
    }
}
