package com.example.expensemanagementsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_master")
public class UserMasterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long uId;

    String name;

    String email;
    String phone;

    public UserMasterEntity() {
    }

    public UserMasterEntity(long uId, String name, String email, String phone) {
        this.uId = uId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public UserMasterEntity(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}
