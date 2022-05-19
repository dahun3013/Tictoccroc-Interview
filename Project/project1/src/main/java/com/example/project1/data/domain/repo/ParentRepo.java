package com.example.project1.data.domain.repo;

import com.example.project1.data.domain.ParentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepo extends JpaRepository<ParentEntity, Long> {
}
