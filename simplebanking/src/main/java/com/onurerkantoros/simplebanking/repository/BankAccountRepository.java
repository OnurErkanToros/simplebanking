package com.onurerkantoros.simplebanking.repository;

import com.onurerkantoros.simplebanking.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {

}
