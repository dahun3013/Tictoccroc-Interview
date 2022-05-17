package com.example.project1.domain.repo;
import com.example.project1.domain.Island;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IslandRepo extends JpaRepository<Island, Long> {
}
