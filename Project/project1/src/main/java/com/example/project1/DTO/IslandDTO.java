package com.example.project1.DTO;

import com.example.project1.domain.IslandEntity;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class IslandDTO {
    private Long islandId;
    private String islandName;
    private String address;

    public IslandEntity toEntity(){
        return IslandEntity.builder()
                .id(islandId)
                .islandName(islandName)
                .address(address)
                .build();
    }
}
