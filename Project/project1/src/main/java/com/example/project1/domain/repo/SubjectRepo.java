package com.example.project1.domain.repo;
import com.example.project1.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepo extends JpaRepository<Subject, Long> {
    Subject findByName(String name);
}
