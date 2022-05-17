package com.example.project1.service;

import com.example.project1.DTO.ReservationDTO;
import com.example.project1.domain.Reservation;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationService {
    void makeReservation(ReservationDTO reservation);
    void cancleReservation(ReservationDTO reservation);
    List<Reservation> getParentsSubscriber(Long parentId);
    List<Reservation> getIslandSubscriber(Long islandId);
    List<Reservation> getLeassonSubscriber(Long leassonId);
}
