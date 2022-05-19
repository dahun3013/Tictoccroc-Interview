package com.example.project1.data.domain.repo;
import com.example.project1.data.domain.IslandEntity;
import com.example.project1.data.domain.LessonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonRepo extends JpaRepository<LessonEntity, Long> {
    List<LessonEntity> findAllByIsland(IslandEntity island);
}
