package com.example.project1.DTO;

import com.example.project1.domain.Lesson;
import com.example.project1.domain.Parent;
import lombok.Data;

import java.util.Date;

@Data
public class ReservationDTO {
    private Date reserved;
    private Parent parent;
    private Lesson lesson;
    private int number;
}
