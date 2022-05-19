package com.example.project1.data.domain.repo;
import com.example.project1.data.domain.LessonEntity;
import com.example.project1.data.domain.ParentEntity;
import com.example.project1.data.domain.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepo extends JpaRepository<ReservationEntity,Long>{
    List<ReservationEntity> findAllByLesson(LessonEntity lesson);
    ReservationEntity findByParentAndLesson(ParentEntity parent, LessonEntity lesson);

    boolean existsByParentAndLesson(ParentEntity parent, LessonEntity lesson);

}
