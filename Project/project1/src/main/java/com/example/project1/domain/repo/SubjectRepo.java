package com.example.project1.domain.repo;
import com.example.project1.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepo extends JpaRepository<Subject, Long> {
    List<Subject> findAllByName(String name);
    List<Subject> findAllByPointId(Long pointId);
}
