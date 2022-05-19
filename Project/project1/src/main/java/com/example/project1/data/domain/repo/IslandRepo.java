package com.example.project1.data.domain.repo;
import com.example.project1.data.domain.IslandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IslandRepo extends JpaRepository<IslandEntity, Long> {
}
