package com.example.project1.domain;

import com.example.project1.DTO.ParentDTO;
import com.example.project1.DTO.ReservationDTO;
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
    private Long id;
    private String parentName;
    private String email;

    public ParentDTO toDTO(){
        return ParentDTO.builder()
                .parentId(id)
                .parentName(parentName)
                .email(email)
                .build();
    }
}
