package com.example.project1.controller;

import com.example.project1.DTO.ReservationDTO;
import com.example.project1.domain.ParentEntity;
import com.example.project1.domain.repo.LessonRepo;
import com.example.project1.domain.repo.ParentRepo;
import com.example.project1.service.ReservationServiceImp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ReservationController.class)
public class ReservationControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    ReservationServiceImp reservationService;

    @Test
    @DisplayName("Reservation 데이터 가져오기 테스트")
    void getParentsSubscriber() throws Exception {
        String parentId = "1";

        mockMvc.perform(
                get("/tictoccroc-island/parents/subscriber/"+parentId))
                .andExpect(status().isOk())
                .andExpect(header().string("content-type","application/json"))
                .andExpect(jsonPath("$.reservationId").exists())
                .andDo(print());

    }
}
