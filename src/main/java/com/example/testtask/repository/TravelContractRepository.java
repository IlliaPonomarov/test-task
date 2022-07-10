package com.example.testtask.repository;

import com.example.testtask.model.contracts.TravelContract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelContractRepository extends JpaRepository<TravelContract,Integer> {
}
