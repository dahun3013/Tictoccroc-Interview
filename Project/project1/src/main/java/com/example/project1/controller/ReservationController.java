package com.example.project1.controller;

import com.example.project1.service.ReservationServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class ReservationController {
    @Autowired
    private ReservationServiceImp reservationServiceImp;

    @PostMapping("/reservate")
    public String reservate(
            @RequestParam("email") String email,
            @RequestParam("pointName") String pointName,
            @RequestParam("subjectName") String subjectName,
            @RequestParam("number") int number,
            @RequestParam("date") @DateTimeFormat(iso = ISO.DATE_TIME) LocalDateTime date
            ) throws IOException {

        reservationServiceImp.reservate(email,pointName,subjectName,number,date);
        return email+", "+pointName+", "+subjectName+", "+number;
    }

    @PostMapping("/cancle")
    public String cancle(
            @RequestParam("email") String email,
            @RequestParam("pointName") String pointName,
            @RequestParam("subjectName") String subjectName,
            @RequestParam("number") int number
    ) throws IOException {

        return "";
    }

    @GetMapping("/subscriber/{email}/{pointName}/{subjectName}")
    public String getSubscriber(
            @PathVariable("email") String email,
            @PathVariable("pointName") String pointName,
            @PathVariable("subjectName") String subjectName
    ) throws IOException {

        return "";
    }

    @GetMapping("/history")
    public String getHistory(
            @PathVariable("email") String email,
            @PathVariable("pointName") String pointName,
            @PathVariable("subjectName") String subjectName
    ) throws IOException {

        return "";
    }
}
