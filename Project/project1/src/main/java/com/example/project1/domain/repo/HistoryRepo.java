package com.example.project1.domain.repo;

import com.example.project1.domain.HistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepo extends JpaRepository<HistoryEntity,Long> {
    List<HistoryEntity> findAllByLessonId(Long lessonId);
    List<HistoryEntity> findAllByParentId(Long parentId);
}
