package com.example.project1.service;

import com.example.project1.DTO.LessonDTO;
import com.example.project1.DTO.ParentDTO;
import com.example.project1.DTO.ReservationDTO;
import com.example.project1.domain.ReservationEntity;
import com.example.project1.domain.repo.LessonRepo;
import com.example.project1.domain.repo.ParentRepo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Calendar;
import java.util.Date;

import static org.mockito.BDDMockito.given;

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
        ParentDTO pdto = parentRepo.findById(1L).get().toDTO();
        LessonDTO ldto = lessonRepo.findById(1L).get().toDTO();
        Long id = 1L;
    }
}
