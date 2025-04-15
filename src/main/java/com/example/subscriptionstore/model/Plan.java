package com.example.subscriptionstore.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    private String description;
    
    private BigDecimal price;
    
    // Período da assinatura em dias (por exemplo, 30 para mensal)
    private int periodDays;

    // Construtores
    public Plan() {
    }

    public Plan(String name, String description, BigDecimal price, int periodDays) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.periodDays = periodDays;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }
    
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    public int getPeriodDays() {
        return periodDays;
    }
    
    public void setPeriodDays(int periodDays) {
        this.periodDays = periodDays;
    }
}
