package com.bauti.shared_expenses_backend.repository;

import com.bauti.shared_expenses_backend.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Integer> {
    
}
