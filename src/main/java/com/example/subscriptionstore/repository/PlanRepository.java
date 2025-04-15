package com.example.subscriptionstore.repository;

import com.example.subscriptionstore.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Long> {
    // métodos customizados, se necessário
}
