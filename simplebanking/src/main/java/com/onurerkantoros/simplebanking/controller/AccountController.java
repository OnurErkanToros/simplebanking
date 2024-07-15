package com.onurerkantoros.simplebanking.controller;

import com.onurerkantoros.simplebanking.dto.*;
import com.onurerkantoros.simplebanking.exceptions.AccountNotFoundException;
import com.onurerkantoros.simplebanking.entity.BankAccount;
import com.onurerkantoros.simplebanking.exceptions.InsufficientBalanceException;
import com.onurerkantoros.simplebanking.services.BankAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/account/v1")
public class AccountController {
    private final BankAccountService bankAccountService;

    public AccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @PostMapping("/create/account")
    public ResponseEntity<BankAccount> createAccount(@RequestBody CreateAccountRequestDto createAccountRequestDto) {
        BankAccount account = bankAccountService.createAccount(createAccountRequestDto);
        return ResponseEntity.ok(account);
    }

    @PostMapping("/credit/{accountNumber}")
    public ResponseEntity<DepositResponseDto> deposit(@PathVariable String accountNumber, @RequestBody DepositRequestDto depositRequestDto) throws InsufficientBalanceException, AccountNotFoundException {
        BankAccount account = bankAccountService.deposit(accountNumber, depositRequestDto.getAmount());
        return ResponseEntity.ok(new DepositResponseDto("OK",account.getTransactions().getLast().getApprovalCode()));
    }

    @PostMapping("/debit/{accountNumber}")
    public ResponseEntity<WithdrawResponseDto> withdraw(@PathVariable String accountNumber, @RequestBody WithdrawRequestDto withdrawRequestDto) throws InsufficientBalanceException, AccountNotFoundException {
        BankAccount account = bankAccountService.withdraw(accountNumber, withdrawRequestDto.getAmount());
        return ResponseEntity.ok(new WithdrawResponseDto("OK",account.getTransactions().getLast().getApprovalCode()));
    }

    @PostMapping("/pay-phone-bill/{accountNumber}")
    public ResponseEntity<PhoneBillPaymentResponseDto> payPhoneBill(@PathVariable String accountNumber, @RequestBody PhoneBillPaymentRequestDto phoneBillPaymentRequestDto) throws InsufficientBalanceException, AccountNotFoundException {
        BankAccount account = bankAccountService.payPhoneBill(accountNumber, phoneBillPaymentRequestDto.getProvider(), phoneBillPaymentRequestDto.getPhoneNumber(), phoneBillPaymentRequestDto.getAmount());
        return ResponseEntity.ok(new PhoneBillPaymentResponseDto("OK",account.getTransactions().getLast().getApprovalCode()));
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<BankAccount> getAccount(@PathVariable String accountNumber) throws AccountNotFoundException {
        BankAccount account = bankAccountService.getAccount(accountNumber);
        return ResponseEntity.ok(account);
    }

    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<String> handleInsufficientBalanceException(InsufficientBalanceException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<String> handleAccountNotFoundException(AccountNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

}
