package com.example.expensemanagementsystem.controller;

import com.example.expensemanagementsystem.service.CsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("csv")
public class CsvController {
    @Autowired
    CsvService csvService;

    @PostMapping("read")
    public List<String> getTransactionData(@RequestParam MultipartFile file) {
        return csvService.readFile(file);
    }

}
