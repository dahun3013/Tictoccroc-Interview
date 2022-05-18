package com.example.project1.domain.repo;
import com.example.project1.domain.LessonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonRepo extends JpaRepository<LessonEntity, Long> {
    List<LessonEntity> findAllByIslandId(Long islandId);
}
