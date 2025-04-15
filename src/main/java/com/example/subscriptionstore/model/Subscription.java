package com.example.subscriptionstore.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // Relacionamento com o usuário
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    // Relacionamento com o plano
    @ManyToOne
    @JoinColumn(name = "plan_id")
    private Plan plan;
    
    private LocalDate startDate;
    
    private LocalDate endDate;
    
    private boolean active;

    // Construtores
    public Subscription() {
    }

    public Subscription(User user, Plan plan, LocalDate startDate, LocalDate endDate, boolean active) {
        this.user = user;
        this.plan = plan;
        this.startDate = startDate;
        this.endDate = endDate;
        this.active = active;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    public Plan getPlan() {
        return plan;
    }
    
    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public LocalDate getStartDate() {
        return startDate;
    }
    
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    
    public LocalDate getEndDate() {
        return endDate;
    }
    
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    
    public boolean isActive() {
        return active;
    }
    
    public void setActive(boolean active) {
        this.active = active;
    }
}
