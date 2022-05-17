package com.example.project1.domain.repo;
import com.example.project1.domain.Leasson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeassonRepo extends JpaRepository<Leasson, Long> {
    Leasson findByLeassonId(Long leassonId);
    List<Leasson> findAllByLeassonName(String leassonName);
    List<Leasson> findAllByIslandId(Long islandId);
}
