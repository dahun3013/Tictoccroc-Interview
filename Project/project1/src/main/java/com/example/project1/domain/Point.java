package com.example.project1.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tbl_point")
@Builder(builderMethodName = "PointBuilder")
@NoArgsConstructor
@AllArgsConstructor
public class Point {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
}
