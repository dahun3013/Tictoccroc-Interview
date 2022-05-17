package com.example.project1.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder(builderMethodName = "PointBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Island {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long islandId;
    private String islandName;
    private String address;
}
