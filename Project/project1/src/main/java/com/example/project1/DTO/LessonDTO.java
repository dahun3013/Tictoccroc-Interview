package com.example.project1.DTO;

import com.example.project1.domain.Island;
import lombok.Data;

@Data
public class LessonDTO {
    private Island island;
    private String lessonName;
    private int currentNum;
    private int maxNum;
}
