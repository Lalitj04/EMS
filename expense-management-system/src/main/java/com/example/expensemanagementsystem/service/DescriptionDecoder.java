package com.example.expensemanagementsystem.service;

import org.springframework.stereotype.Service;

@Service
public interface DescriptionDecoder {

    public String decodeDescription(String description);

}
