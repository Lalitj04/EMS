package com.example.expensemanagementsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "bank_details")
public class BankDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long bId;

    String name;

    String code;

    public BankDetailsEntity(long bId, String name, String code) {
        this.bId = bId;
        this.name = name;
        this.code = code;
    }
}
