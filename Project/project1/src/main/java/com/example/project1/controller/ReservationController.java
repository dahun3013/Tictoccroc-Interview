package com.example.project1.controller;

import com.example.project1.DTO.ReservationDTO;
import com.example.project1.service.ReservationServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/tictoccroc-island")
public class ReservationController {
    @Autowired
    private ReservationServiceImp reservationServiceImp;
    //예약
    //예약취소
    //매장 의 예약 조회 [부모님]
    //매장 의 예약내역 반환 {전체수업의 예약내역을 List로 담아서 줘야지}
    //매장 의 해당수업 예약내역 반환

    @PostMapping("/parent/lessonReservation")
    @Operation(summary = "예약", description = "째깍섬 예약 API")
    public ResponseEntity lessonReservation(
            @RequestBody ReservationDTO reservation
    ){
        reservationServiceImp.makeReservation(reservation);
        return new ResponseEntity<>(reservation, HttpStatus.OK);
    }

    @PostMapping("/parent/lessonCancel")
    @Operation(summary = "예약취소", description = "째깍섬 예약취소 API")
    public ResponseEntity lessonCancel(
            @RequestBody ReservationDTO reservation
    ){
        reservationServiceImp.cancelReservation(reservation);
        return new ResponseEntity<>(reservation, HttpStatus.OK);
    }

    @GetMapping("/parents/subscriber/{parentId}")
    @Operation(summary = "예약조회[부모]", description = "째깍섬 부모의 예약조회 API")
    public ResponseEntity parentsSubscriber(
            @PathVariable("parentId") Long parentId
    ){
        return new ResponseEntity<>(reservationServiceImp.getParentsSubscriber(parentId),HttpStatus.OK);
    }

    @GetMapping("/island/subscriber/{islandId}")
    @Operation(summary = "예약조회[매장]", description = "째깍섬 매장별 예약조회 API")
    public ResponseEntity islandSubscriber(
            @PathVariable("islandId") Long islandId
    ){
        return new ResponseEntity<>(reservationServiceImp.getParentsSubscriber(islandId),HttpStatus.OK);
    }

    @GetMapping("/lesson/subscriber/{lessonId}")
    @Operation(summary = "예약조회[수업]", description = "째깍섬 수업별 예약조회 API")
    public ResponseEntity leassonSubsriber(
            @PathVariable("lessonId") Long lessonId
    ){
        return new ResponseEntity<>(reservationServiceImp.getParentsSubscriber(lessonId),HttpStatus.OK);
    }

    @GetMapping("/island/history/{islandId}")
    @Operation(summary = "예약이력조회[매장]", description = "째깍섬 매장별 예약이력조회 API")
    public String islandHistory(
            @PathVariable("islandId") Long islandId
    ){

        return "";
    }

    @GetMapping("/lesson/history/{lessonId}")
    @Operation(summary = "예약이력조회[수업]", description = "째깍섬 수업별 예약이력조회 API")
    public String leassonHistory(
            @PathVariable("lessonId") Long lessonId
    ){

        return "";
    }
}
