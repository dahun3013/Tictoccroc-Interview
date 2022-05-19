package com.example.project1.data.domain.repo;

import com.example.project1.data.domain.HistoryEntity;
import com.example.project1.data.domain.LessonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepo extends JpaRepository<HistoryEntity,Long> {
    List<HistoryEntity> findAllByLesson(LessonEntity lesson);
}
