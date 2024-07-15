package com.onurerkantoros.simplebanking.repository;

import com.onurerkantoros.simplebanking.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
