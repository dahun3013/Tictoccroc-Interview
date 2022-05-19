package com.example.project1.data.dto;

import com.example.project1.data.domain.LessonEntity;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LessonDTO {
    private Long lessonId;
    private IslandDTO island;
    private String lessonName;
    private int currentNum;
    private int maxNum;
}
