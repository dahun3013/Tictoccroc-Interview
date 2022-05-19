package com.example.project1.data.domain;

import com.example.project1.data.dto.ParentDTO;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "parent")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ParentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long parentId;
    private String parentName;
    @Column(unique = true)
    private String email;
}
