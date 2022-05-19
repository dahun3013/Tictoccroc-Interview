package com.example.project1.domain.repo;
import com.example.project1.domain.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepo extends JpaRepository<ReservationEntity,Long>{
    List<ReservationEntity> findAllByLessonId(Long lessonId);
    ReservationEntity findByParentIdAndLessonId(Long parentId, Long lessonId);

    boolean existsByParentIdAndLessonId(Long parentId, Long lessonId);

}
