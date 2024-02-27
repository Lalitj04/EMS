package com.example.expensemanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "tnx_description_analysis")
public class TnxDescriptionAnalysis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long aId;

    String keyword;

    String operation;

    String type;

    String index;

    public TnxDescriptionAnalysis() {
    }

    public TnxDescriptionAnalysis(long aId, String keyword, String operation, String type, String index) {
        this.aId = aId;
        this.keyword = keyword;
        this.operation = operation;
        this.type = type;
        this.index = index;
    }
}
