package com.example.project1.domain.repo;
import com.example.project1.domain.Lesson;
import com.example.project1.domain.Parent;
import com.example.project1.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepo extends JpaRepository<Reservation,Long>{
    List<Reservation> findAllByParentId(Long parentId);
    List<Reservation> findAllByLessonId(Long lessonId);
    Reservation findByParentIdAndLessonId(Long parentId, Long lessonId);

}
