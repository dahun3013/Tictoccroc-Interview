package com.example.project1.domain;

import com.example.project1.DTO.HistoryDTO;
import com.example.project1.DTO.ReservationDTO;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "history")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @ManyToOne
    private ParentEntity parent;
    @ManyToOne
    private LessonEntity lesson;
    private String activity;

    public HistoryDTO toDTO(){
        return HistoryDTO.builder()
                .historyId(id)
                .date(date)
                .parent(parent.toDTO())
                .lesson(lesson.toDTO())
                .activity(activity)
                .build();
    }
}
