package com.example.subscriptionstore.repository;

import com.example.subscriptionstore.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    // métodos customizados, se necessário
}
