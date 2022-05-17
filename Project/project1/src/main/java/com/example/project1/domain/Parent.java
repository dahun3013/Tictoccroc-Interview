package com.example.project1.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder(builderMethodName = "ParentBuilder")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long parentId;
    private String parentName;
    private String email;
}
