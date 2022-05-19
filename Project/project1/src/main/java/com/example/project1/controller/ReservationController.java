package com.example.project1.controller;

import com.example.project1.data.dto.ReservationDTO;
import com.example.project1.common.enums.SuccessCode;
import com.example.project1.common.response.BasicResponse;
import com.example.project1.common.response.CommonResponse;
import com.example.project1.service.ReservationServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tictoccroc-island")
public class ReservationController {
    @Autowired
    private ReservationServiceImp reservationServiceImp;

    @PostMapping("/parent/lessonReservation")
    @Operation(summary = "예약", description = "째깍섬 예약 API")
    public ResponseEntity<? extends BasicResponse> lessonReservation(
            @RequestBody ReservationDTO reservationDTO
    ){
        reservationServiceImp.makeReservation(reservationDTO);
        CommonResponse cr = new CommonResponse(
                SuccessCode.CREATE.getCode()
                , "CREATE_SUCCESS");
        return new ResponseEntity<>(cr,HttpStatus.OK);
    }

    @DeleteMapping("/parent/lessonCancel")
    @Operation(summary = "예약취소", description = "째깍섬 예약취소 API")
    public ResponseEntity<? extends BasicResponse> lessonCancel(
            @RequestBody ReservationDTO reservationDTO
    ){
        reservationServiceImp.cancelReservation(reservationDTO);
        CommonResponse cr = new CommonResponse(
                SuccessCode.SUCCESS.getCode()
                , "DELETE_SUCCESS");
        return new ResponseEntity<>(cr, HttpStatus.OK);
    }

    @GetMapping("/island/subscriber/{islandId}")
    @Operation(summary = "예약조회[매장]", description = "째깍섬 매장별 예약조회 API")
    public ResponseEntity<CommonResponse> islandSubscriber(
            @PathVariable("islandId") Long islandId
    ){

        CommonResponse cr = new CommonResponse(
                SuccessCode.SUCCESS.getCode()
                , "SUCCESS"
                , reservationServiceImp.getIslandSubscriber(islandId));
        return new ResponseEntity<>(cr,HttpStatus.OK);
    }

    @GetMapping("/lesson/subscriber/{lessonId}")
    @Operation(summary = "예약조회[수업]", description = "째깍섬 수업별 예약조회 API")
    public ResponseEntity<CommonResponse> lessonSubscriber(
            @PathVariable("lessonId") Long lessonId
    ){
        CommonResponse cr = new CommonResponse(
                SuccessCode.SUCCESS.getCode()
                , "SUCCESS"
                , reservationServiceImp.getLessonSubscriber(lessonId));
        return new ResponseEntity<>(cr,HttpStatus.OK);
    }

    @GetMapping("/island/history/{islandId}")
    @Operation(summary = "예약이력조회[매장]", description = "째깍섬 매장별 예약이력조회 API")
    public ResponseEntity<CommonResponse> islandHistory(
            @PathVariable("islandId") Long islandId
    ){
        CommonResponse cr = new CommonResponse(
                SuccessCode.SUCCESS.getCode()
                , "SUCCESS"
                , reservationServiceImp.getIslandHistory(islandId));
        return new ResponseEntity<>(cr,HttpStatus.OK);
    }

    @GetMapping("/lesson/history/{lessonId}")
    @Operation(summary = "예약이력조회[수업]", description = "째깍섬 수업별 예약이력조회 API")
    public ResponseEntity<CommonResponse> lessonHistory(
            @PathVariable("lessonId") Long lessonId
    ){
        CommonResponse cr = new CommonResponse(
                SuccessCode.SUCCESS.getCode()
                , "SUCCESS"
                , reservationServiceImp.getLessonHistory(lessonId));
        return new ResponseEntity<>(cr,HttpStatus.OK);
    }
}
