package com.example.project1.domain;

import com.example.project1.DTO.LessonDTO;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "lesson")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LessonEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private IslandEntity island;
    private String lessonName;
    private int currentNum;
    private int maxNum;

    public LessonDTO toDTO(){
        return LessonDTO.builder()
                .lessonId(id)
                .island(island.toDTO())
                .lessonName(lessonName)
                .currentNum(currentNum)
                .maxNum(maxNum)
                .build();
    }
}
