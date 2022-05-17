package com.example.project1.DTO;

import com.example.project1.domain.Leasson;
import com.example.project1.domain.Parent;
import lombok.Data;

import java.util.Date;

@Data
public class ReservationDTO {
    private Date reserved;
    private Parent parent;
    private Leasson leasson;
    private int number;
}
