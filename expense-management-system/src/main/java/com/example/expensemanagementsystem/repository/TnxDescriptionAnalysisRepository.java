package com.example.expensemanagementsystem.repository;

import com.example.expensemanagementsystem.entity.TnxDescriptionAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TnxDescriptionAnalysisRepository extends JpaRepository<TnxDescriptionAnalysis, Long> {

    public List<TnxDescriptionAnalysis> findByOperation(String operation);
}
