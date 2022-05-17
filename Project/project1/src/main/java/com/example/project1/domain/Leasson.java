package com.example.project1.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder(builderMethodName = "SubjectBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Leasson {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long leassonId;
    @ManyToOne
    private Island island;
    private String leassonName;
    private int currentNum;
    private int maxNum;
}
