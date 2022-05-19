package com.example.project1.data.domain;

import com.example.project1.data.dto.LessonDTO;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

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
    private Long lessonId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "island_id")
    private IslandEntity island;
    private String lessonName;
    @ColumnDefault("0")
    private int currentNum;
    @ColumnDefault("20")
    private int maxNum;
}
