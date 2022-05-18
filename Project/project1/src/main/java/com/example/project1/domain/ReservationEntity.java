package com.example.project1.domain;

import com.example.project1.DTO.ReservationDTO;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservation")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReservationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @ManyToOne
    private ParentEntity parent;
    @ManyToOne
    private LessonEntity lesson;
    private int number;

    public ReservationDTO toDTO(){
        return ReservationDTO.builder()
                .reservationId(id)
                .date(date)
                .parent(parent.toDTO())
                .lesson(lesson.toDTO())
                .build();
    }
}
