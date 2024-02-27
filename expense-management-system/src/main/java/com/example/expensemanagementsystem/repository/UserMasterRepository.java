package com.example.expensemanagementsystem.repository;

import com.example.expensemanagementsystem.entity.UserMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMasterRepository extends JpaRepository<UserMasterEntity,Long> {
}
