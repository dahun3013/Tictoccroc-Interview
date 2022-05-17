package com.example.project1.domain.repo;

import com.example.project1.domain.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepo extends JpaRepository<History,Long> {
}
