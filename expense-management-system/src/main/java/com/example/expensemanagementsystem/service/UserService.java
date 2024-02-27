package com.example.expensemanagementsystem.service;

import com.example.expensemanagementsystem.dto.requests.UserRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public void saveUserDetails(UserRequest userRequest);
}
