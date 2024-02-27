package com.example.expensemanagementsystem.entity;

import jakarta.persistence.*;
import org.joda.time.DateTime;

@Entity
@Table(name = "transaction_exception")
public class TransactionsExceptionsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long eId;

    String description;

    DateTime date;

    public TransactionsExceptionsEntity(long eId, String description, DateTime date) {
        this.eId = eId;
        this.description = description;
        this.date = date;
    }
}
