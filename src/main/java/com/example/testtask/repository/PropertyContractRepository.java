package com.example.testtask.repository;

import com.example.testtask.model.contracts.PropertyContract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyContractRepository extends JpaRepository<PropertyContract, Integer> {
}
