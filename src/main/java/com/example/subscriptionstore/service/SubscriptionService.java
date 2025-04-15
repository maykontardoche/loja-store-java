package com.example.subscriptionstore.service;

import com.example.subscriptionstore.model.Plan;
import com.example.subscriptionstore.model.Subscription;
import com.example.subscriptionstore.model.User;
import com.example.subscriptionstore.repository.SubscriptionRepository;
import com.example.subscriptionstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private UserRepository userRepository;

    /**
     * Cria uma assinatura para o usuário com base em um plano.
     * Calcula a data final adicionando o período (em dias) do plano à data de início.
     */
    public Subscription createSubscription(User user, Plan plan) {
        // Salva o usuário se não existir ainda
        if(user.getId() == null) {
            user = userRepository.save(user);
        }
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(plan.getPeriodDays());
        Subscription subscription = new Subscription(user, plan, startDate, endDate, true);
        return subscriptionRepository.save(subscription);
    }

    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    public Optional<Subscription> getSubscriptionById(Long id) {
        return subscriptionRepository.findById(id);
    }

    public Subscription cancelSubscription(Long id) {
        Optional<Subscription> opSubscription = subscriptionRepository.findById(id);
        if (opSubscription.isPresent()) {
            Subscription subscription = opSubscription.get();
            subscription.setActive(false);
            subscriptionRepository.save(subscription);
            return subscription;
        } else {
            throw new RuntimeException("Assinatura não encontrada!");
        }
    }
}
