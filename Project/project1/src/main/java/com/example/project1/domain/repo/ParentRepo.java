package com.example.project1.domain.repo;

import com.example.project1.domain.ParentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepo extends JpaRepository<ParentEntity, Long> {
}
