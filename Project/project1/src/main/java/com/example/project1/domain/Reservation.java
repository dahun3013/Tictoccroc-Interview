package com.example.project1.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Builder(builderMethodName = "ReservationBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @ManyToOne
    private Parent parent;
    @ManyToOne
    private Lesson lesson;
}
