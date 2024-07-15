package com.onurerkantoros.simplebanking;

import com.onurerkantoros.simplebanking.exceptions.InsufficientBalanceException;
import com.onurerkantoros.simplebanking.entity.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountTest {
    @Test
    public void testAccountTransactions() throws InsufficientBalanceException {
        BankAccount account = new BankAccount("Jim", 12345);

        account.post(new DepositTransaction(1000));
        account.post(new WithdrawalTransaction(200));
        account.post(new BillPaymentTransaction("Vodafone", "5423345566", 96.50));

        assertEquals(703.50, account.getBalance(), 0.0001);
    }
}
