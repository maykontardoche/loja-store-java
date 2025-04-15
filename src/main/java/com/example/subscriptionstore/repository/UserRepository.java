package com.example.subscriptionstore.repository;

import com.example.subscriptionstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Caso deseje métodos customizados, exemplo:
    User findByEmail(String email);
}
