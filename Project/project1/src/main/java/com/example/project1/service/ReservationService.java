package com.example.project1.service;


import com.example.project1.DTO.LessonDTO;
import com.example.project1.DTO.ParentDTO;
import com.example.project1.DTO.ReservationDTO;

import java.util.Date;
import java.util.List;

public interface ReservationService {
    ReservationDTO createReservation(Long id, Date date, ParentDTO pdto, LessonDTO ldto, int number);
    void makeReservation(ReservationDTO reservationDTO);
    void cancelReservation(ReservationDTO reservationDTO);
    List<ReservationDTO> getParentsSubscriber(Long parentId);
    List<ReservationDTO> getIslandSubscriber(Long islandId);
    List<ReservationDTO> getLessonSubscriber(Long lessonId);
}
