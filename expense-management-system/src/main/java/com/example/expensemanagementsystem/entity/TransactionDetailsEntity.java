package com.example.expensemanagementsystem.entity;

import jakarta.persistence.*;
import org.joda.time.DateTime;


@Entity
@Table(name = "transactions_details")
public class TransactionDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long tId;
    long rId;

    long uId;

    long bId;
    String transferTo;
    DateTime transactionsDate;

    double transaction;

    Double balance;

    public TransactionDetailsEntity(long tId, long rId, long uId, long bId, String transferTo, DateTime transactionsDate, double transaction, Double balance) {
        this.tId = tId;
        this.rId = rId;
        this.uId = uId;
        this.bId = bId;
        this.transferTo = transferTo;
        this.transactionsDate = transactionsDate;
        this.transaction = transaction;
        this.balance = balance;
    }
}
