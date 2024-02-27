package com.example.expensemanagementsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "receiver_details")
public class ReceiverDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long rId;
    String name;
    String code;
    String type;

}
