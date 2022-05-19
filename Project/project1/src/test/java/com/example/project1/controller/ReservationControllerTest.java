package com.example.project1.controller;

import com.example.project1.data.dto.*;
import com.example.project1.service.ReservationServiceImp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.verify;
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
    @DisplayName("lessonReservation 예약하기 테스트")
    void lessonReservationTest() throws Exception {
        //given
        ParentDTO parentDTO = ParentDTO.builder()
                .parentId(2L)
                .parentName("홍길동")
                .email("test1@naver.com")
                .build();
        AddressDTO addressDTO = AddressDTO.builder()
                .addressId(1L)
                .address1("서울")
                .address2("송파구")
                .address3("올림픽로 300 롯데월드몰 엔터테인먼트동 4층 (롯데시네마 바로 아래 4층 수수가든 옆)")
                .build();
        IslandDTO islandDTO = IslandDTO.builder()
                .islandId(1L)
                .islandName("잠실점")
                .address(addressDTO)
                .build();
        LessonDTO lessonDTO = LessonDTO.builder()
                .lessonId(2L)
                .island(islandDTO)
                .lessonName("도시농부")
                .currentNum(10)
                .maxNum(20)
                .build();
        ReservationDTO reservationDTO = ReservationDTO.builder()
                .reservationId(1L)
                .date(new Date())
                .parent(parentDTO)
                .lesson(lessonDTO)
                .number(10)
                .build();
        reservationService.makeReservation(reservationDTO);

        //when
        final ResultActions actions =
                mockMvc.perform(
                        post("/tictoccroc-island/parent/lessonReservation")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .content(
                                        "{\n" +
                                                "    \"reservationId\": 1,\n" +
                                                "    \"date\": \"2022-05-22T00:00:00.000+00:00\",\n" +
                                                "    \"parent\": {\n" +
                                                "        \"parentId\": 2,\n" +
                                                "        \"email\": \"test1@naver.com\",\n" +
                                                "        \"parentName\": \"홍길동\"\n" +
                                                "    },\n" +
                                                "    \"lesson\": {\n" +
                                                "        \"lessonId\": 2,\n" +
                                                "        \"island\": {\n" +
                                                "            \"islandId\": 1,\n" +
                                                "            \"islandName\": \"잠실점\",\n" +
                                                "            \"address\": {\n" +
                                                "                \"addressId\": 1,\n" +
                                                "                \"address1\": \"서울\",\n" +
                                                "                \"address2\": \"송파구\",\n" +
                                                "                \"address3\": \"올림픽로 300 롯데월드몰 엔터테인먼트동 4층 (롯데시네마 바로 아래 4층 수수가든 옆)\"\n" +
                                                "            }\n" +
                                                "        },\n" +
                                                "        \"lessonName\": \"도시농부\",\n" +
                                                "        \"currentNum\": 10,\n" +
                                                "        \"maxNum\": 20\n" +
                                                "    },\n" +
                                                "    \"number\": 10\n" +
                                                "}"
                                )
                );

        //then
        actions
                .andExpect(status().isOk())
                .andExpect(jsonPath("code").value(201))
                .andExpect(jsonPath("message").value("CREATE_SUCCESS"));
    }

    @Test
    @DisplayName("Reservation 데이터 가져오기 테스트")
    void getIslandSubscriber() throws Exception {
        //given
        ParentDTO parentDTO = ParentDTO.builder()
                .parentId(2L)
                .parentName("홍길동")
                .email("test1@naver.com")
                .build();
        AddressDTO addressDTO = AddressDTO.builder()
                .addressId(1L)
                .address1("서울")
                .address2("송파구")
                .address3("올림픽로 300 롯데월드몰 엔터테인먼트동 4층 (롯데시네마 바로 아래 4층 수수가든 옆)")
                .build();
        IslandDTO islandDTO = IslandDTO.builder()
                .islandId(1L)
                .islandName("잠실점")
                .address(addressDTO)
                .build();
        LessonDTO lessonDTO = LessonDTO.builder()
                .lessonId(2L)
                .island(islandDTO)
                .lessonName("도시농부")
                .currentNum(10)
                .maxNum(20)
                .build();
        ReservationDTO reservationDTO = ReservationDTO.builder()
                .reservationId(1L)
                .date(new Date())
                .parent(parentDTO)
                .lesson(lessonDTO)
                .number(10)
                .build();

        reservationService.makeReservation(reservationDTO);

        String islandId = "1";

        //when
        final ResultActions actions =
                mockMvc.perform(
                        get("/tictoccroc-island/island/subscriber/1")
                                .contentType(MediaType.APPLICATION_JSON)
                )
                        .andDo(print());
    }


}
