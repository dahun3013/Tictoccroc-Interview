package com.example.project1.service;

import com.example.project1.domain.Reservation;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationService {
    void reservate(String email, String pointName, String subjectName, int number, LocalDateTime date);
    void cancle(String email, String pointName, String subjectName);
    List<Reservation> searchForPoint(String name);
    List<Reservation> searchForSubject(String name);
}
