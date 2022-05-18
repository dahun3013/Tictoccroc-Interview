package com.example.project1.controller;

import com.example.project1.domain.Reservation;
import com.example.project1.service.ReservationServiceImp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;

@WebMvcTest(ReservationController.class)
public class ReservationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ReservationServiceImp reservationService;

    @Test
    @DisplayName("Reservation 데이터 가져오기 테스트")
    void getReservationTest() throws Exception{
        //given(reservationService.makeReservation(Reservation.ReservationBuilder().));

    }
}
