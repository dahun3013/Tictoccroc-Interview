package com.example.project1.domain;

import com.example.project1.DTO.IslandDTO;
import com.example.project1.DTO.ReservationDTO;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "island")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IslandEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String islandName;
    private String address;

    public IslandDTO toDTO(){
        return IslandDTO.builder()
                .islandId(id)
                .islandName(islandName)
                .address(address)
                .build();
    }
}
