package com.example.project1.controller;

import com.example.project1.DTO.ReservationDTO;
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
        CommonResponse cr = new CommonResponse();
        cr.setMessage("SUCCUES");
        cr.setData(reservationDTO);
        cr.setCode(SuccessCode.SUCCESS.getCode());
        return new ResponseEntity<>(cr,HttpStatus.OK);
    }

    @PostMapping("/parent/lessonCancel")
    @Operation(summary = "예약취소", description = "째깍섬 예약취소 API")
    public ResponseEntity<? extends BasicResponse> lessonCancel(
            @RequestBody ReservationDTO reservationDTO
    ){
        reservationServiceImp.cancelReservation(reservationDTO);
        CommonResponse cr = new CommonResponse();
        cr.setMessage("SUCCUES");
        cr.setData(reservationDTO);
        cr.setCode(SuccessCode.SUCCESS.getCode());
        return new ResponseEntity<>(cr, HttpStatus.OK);
    }

    @GetMapping("/parents/subscriber/{parentId}")
    @Operation(summary = "예약조회[부모]", description = "째깍섬 부모의 예약조회 API")
    public ResponseEntity<? extends BasicResponse> parentsSubscriber(
            @PathVariable("parentId") Long parentId
    ){
        CommonResponse cr = new CommonResponse();
        cr.setMessage("SUCCUES");
        cr.setData(reservationServiceImp.getParentsSubscriber(parentId));
        cr.setCode(SuccessCode.SUCCESS.getCode());
        return new ResponseEntity<>(cr,HttpStatus.OK);
    }

    @GetMapping("/island/subscriber/{islandId}")
    @Operation(summary = "예약조회[매장]", description = "째깍섬 매장별 예약조회 API")
    public ResponseEntity<? extends BasicResponse> islandSubscriber(
            @PathVariable("islandId") Long islandId
    ){

        CommonResponse cr = new CommonResponse();
        cr.setMessage("SUCCUES");
        cr.setData(reservationServiceImp.getIslandSubscriber(islandId));
        cr.setCode(SuccessCode.SUCCESS.getCode());
        return new ResponseEntity<>(cr,HttpStatus.OK);
    }

    @GetMapping("/lesson/subscriber/{lessonId}")
    @Operation(summary = "예약조회[수업]", description = "째깍섬 수업별 예약조회 API")
    public ResponseEntity<? extends BasicResponse> lessonSubscriber(
            @PathVariable("lessonId") Long lessonId
    ){
        CommonResponse cr = new CommonResponse();
        cr.setMessage("SUCCUES");
        cr.setData(reservationServiceImp.getLessonSubscriber(lessonId));
        cr.setCode(SuccessCode.SUCCESS.getCode());
        return new ResponseEntity<>(cr,HttpStatus.OK);
    }

    @GetMapping("/island/history/{islandId}")
    @Operation(summary = "예약이력조회[매장]", description = "째깍섬 매장별 예약이력조회 API")
    public ResponseEntity<? extends BasicResponse> islandHistory(
            @PathVariable("islandId") Long islandId
    ){
        CommonResponse cr = new CommonResponse();
        cr.setMessage("SUCCUES");
        cr.setData(reservationServiceImp.getIslandHistory(islandId));
        cr.setCode(SuccessCode.SUCCESS.getCode());
        return new ResponseEntity<>(cr,HttpStatus.OK);
    }

    @GetMapping("/lesson/history/{lessonId}")
    @Operation(summary = "예약이력조회[수업]", description = "째깍섬 수업별 예약이력조회 API")
    public ResponseEntity<? extends BasicResponse> leassonHistory(
            @PathVariable("lessonId") Long lessonId
    ){
        CommonResponse cr = new CommonResponse();
        cr.setMessage("SUCCUES");
        cr.setData(reservationServiceImp.getLessonHistory(lessonId));
        cr.setCode(SuccessCode.SUCCESS.getCode());
        return new ResponseEntity<>(cr,HttpStatus.OK);
    }
}
