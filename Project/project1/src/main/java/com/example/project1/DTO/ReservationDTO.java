package com.example.project1.DTO;

import com.example.project1.domain.ReservationEntity;
import lombok.*;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class ReservationDTO {
    private Long reservationId;
    private Date date;
    private ParentDTO parent;
    private LessonDTO lesson;
    private int number;

    public ReservationEntity toEntity(){
        return ReservationEntity.builder()
                .id(reservationId)
                .date(date)
                .parent(parent.toEntity())
                .lesson(lesson.toEntity())
                .number(number)
                .build();
    }
}
