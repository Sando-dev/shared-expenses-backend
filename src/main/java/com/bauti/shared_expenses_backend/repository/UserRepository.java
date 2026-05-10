package com.bauti.shared_expenses_backend.repository;

import com.bauti.shared_expenses_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    
}
