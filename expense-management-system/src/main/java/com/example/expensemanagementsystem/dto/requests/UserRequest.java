package com.example.expensemanagementsystem.dto.requests;

import com.example.expensemanagementsystem.entity.UserMasterEntity;

public class UserRequest {
    String name;
    String email;
    String phone;

    public UserRequest(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public UserMasterEntity convertToEntity(){
        return new UserMasterEntity(this.name,this.email,this.phone);
    }
}
