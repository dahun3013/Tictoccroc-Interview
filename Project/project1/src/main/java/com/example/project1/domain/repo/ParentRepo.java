package com.example.project1.domain.repo;

import com.example.project1.domain.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepo extends JpaRepository<Parent, Long> {
    Parent findByEmail(String email);
}
