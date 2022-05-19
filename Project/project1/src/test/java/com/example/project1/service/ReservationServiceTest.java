package com.example.project1.service;

import com.example.project1.data.dto.LessonDTO;
import com.example.project1.data.dto.ParentDTO;
import com.example.project1.data.domain.repo.LessonRepo;
import com.example.project1.data.domain.repo.ParentRepo;
import com.example.project1.data.mapper.LessonMapper;
import com.example.project1.data.mapper.ParentMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Calendar;
import java.util.Date;

//@SpringBootTest(classes = ReservationServiceImp.class)
@ExtendWith(SpringExtension.class)
@Import(ReservationServiceImp.class)
public class ReservationServiceTest {
    @Autowired
    ReservationServiceImp reservationServiceImp;
    @Autowired
    LessonRepo lessonRepo;
    @Autowired
    ParentRepo parentRepo;

    @Test
    @DisplayName("예약 생성 메소드 테스트")
    public void saveReservationTest(){
        Date day = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(day);
        c.add(Calendar.DATE, 1);
        day = c.getTime();
        ParentDTO pdto = ParentMapper.INSTANCE.toDTO(parentRepo.findById(1L).get());
        LessonDTO ldto = LessonMapper.INSTANCE.toDTO(lessonRepo.findById(1L).get());
        Long id = 1L;
    }
}
