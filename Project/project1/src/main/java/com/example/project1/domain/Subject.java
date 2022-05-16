package com.example.project1.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tbl_subject")
@Builder(builderMethodName = "SubjectBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Subject {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Point point;
    private String name;
    private int currentNum;
    private int maxNum;
}
