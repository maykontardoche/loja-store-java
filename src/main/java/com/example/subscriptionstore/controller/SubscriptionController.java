package com.example.subscriptionstore.controller;

import com.example.subscriptionstore.model.Plan;
import com.example.subscriptionstore.model.Subscription;
import com.example.subscriptionstore.model.User;
import com.example.subscriptionstore.service.PlanService;
import com.example.subscriptionstore.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @Autowired
    private PlanService planService;

    /**
     * Endpoint para criar uma assinatura.
     * O JSON esperado deve conter os dados do usuário e o id do plano:
     * {
     *    "user": {
     *         "name": "Fulano",
     *         "email": "fulano@email.com"
     *     },
     *     "planId": 1
     * }
     */
    @PostMapping
    public Subscription createSubscription(@RequestBody SubscriptionRequest request) {
        Optional<Plan> planOpt = planService.getPlanById(request.getPlanId());
        if (!planOpt.isPresent()) {
            throw new RuntimeException("Plano não encontrado!");
        }
        return subscriptionService.createSubscription(request.getUser(), planOpt.get());
    }

    @GetMapping
    public List<Subscription> getAllSubscriptions() {
        return subscriptionService.getAllSubscriptions();
    }

    @PostMapping("/{id}/cancel")
    public Subscription cancelSubscription(@PathVariable Long id) {
        return subscriptionService.cancelSubscription(id);
    }
}

// Classe auxiliar para receber a requisição JSON
class SubscriptionRequest {
    private User user;
    private Long planId;

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Long getPlanId() {
        return planId;
    }
    public void setPlanId(Long planId) {
        this.planId = planId;
    }
}
