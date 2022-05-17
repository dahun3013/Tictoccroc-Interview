package com.example.project1.DTO;

import com.example.project1.domain.Island;
import lombok.Data;

@Data
public class LeassonDTO {
    private Long id;
    private Island island;
    private String name;
    private int currentNum;
    private int maxNum;
}
