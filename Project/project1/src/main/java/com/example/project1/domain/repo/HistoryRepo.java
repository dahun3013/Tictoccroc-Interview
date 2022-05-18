package com.example.project1.domain.repo;

import com.example.project1.domain.HistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepo extends JpaRepository<HistoryEntity,Long> {
}
