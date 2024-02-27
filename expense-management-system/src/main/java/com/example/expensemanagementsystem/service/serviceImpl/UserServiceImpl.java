package com.example.expensemanagementsystem.service.serviceImpl;

import com.example.expensemanagementsystem.dto.requests.UserRequest;
import com.example.expensemanagementsystem.repository.UserMasterRepository;
import com.example.expensemanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMasterRepository userMasterRepository;

    @Override
    public void saveUserDetails(UserRequest userRequest){
        userMasterRepository.save(userRequest.convertToEntity());
    }

}
