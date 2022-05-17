package com.example.project1.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder(builderMethodName = "SubjectBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Lesson {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Island island;
    private String lessonName;
    private int currentNum;
    private int maxNum;
}
