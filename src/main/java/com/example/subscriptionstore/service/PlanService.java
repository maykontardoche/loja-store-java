package com.example.subscriptionstore.service;

import com.example.subscriptionstore.model.Plan;
import com.example.subscriptionstore.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanService {

    @Autowired
    private PlanRepository planRepository;

    public List<Plan> getAllPlans() {
        return planRepository.findAll();
    }

    public Optional<Plan> getPlanById(Long id) {
        return planRepository.findById(id);
    }

    public Plan createPlan(Plan plan) {
        return planRepository.save(plan);
    }

    // Outros métodos (atualizar, remover) podem ser adicionados conforme necessário
}
