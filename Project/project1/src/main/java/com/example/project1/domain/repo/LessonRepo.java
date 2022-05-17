package com.example.project1.domain.repo;
import com.example.project1.domain.Island;
import com.example.project1.domain.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LessonRepo extends JpaRepository<Lesson, Long> {
    List<Lesson> findAllByIslandId(Long islandId);
}
