package com.example.expensemanagementsystem.controller;

import com.example.expensemanagementsystem.dto.requests.UserRequest;
import com.example.expensemanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("create")
    public String createUser(@RequestBody UserRequest userRequest) {
        userService.saveUserDetails(userRequest);
        return "";
    }
}
