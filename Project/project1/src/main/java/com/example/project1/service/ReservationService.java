package com.example.project1.service;


import com.example.project1.DTO.HistoryDTO;
import com.example.project1.DTO.LessonDTO;
import com.example.project1.DTO.ParentDTO;
import com.example.project1.DTO.ReservationDTO;

import java.util.Date;
import java.util.List;

public interface ReservationService {
    void makeReservation(ReservationDTO reservationDTO);
    void cancelReservation(ReservationDTO reservationDTO);
    List<ReservationDTO> getIslandSubscriber(Long islandId);
    List<ReservationDTO> getLessonSubscriber(Long lessonId);
    List<HistoryDTO> getIslandHistory(Long islandId);
    List<HistoryDTO> getLessonHistory(Long lessonId);
}
