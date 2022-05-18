package com.example.project1.DTO;

import com.example.project1.domain.LessonEntity;
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

    public LessonEntity toEntity(){
        return LessonEntity.builder()
                .id(lessonId)
                .island(island.toEntity())
                .lessonName(lessonName)
                .currentNum(currentNum)
                .maxNum(maxNum)
                .build();
    }
}
