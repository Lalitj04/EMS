package com.example.expensemanagementsystem.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface CsvService {

    public List<String> readFile(MultipartFile file);
}
