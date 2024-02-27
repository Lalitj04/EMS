package com.example.expensemanagementsystem.repository;

import com.example.expensemanagementsystem.entity.TransactionDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionsDetailsRepository extends JpaRepository<TransactionDetailsEntity,Long> {
}
