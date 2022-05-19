package com.example.project1.data.dto;

import com.example.project1.data.domain.ReservationEntity;
import lombok.*;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ReservationDTO {
    private Long reservationId;
    private Date date;
    private ParentDTO parent;
    private LessonDTO lesson;
    private int number;
}
