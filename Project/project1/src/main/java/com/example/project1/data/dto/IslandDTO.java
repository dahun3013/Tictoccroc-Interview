package com.example.project1.data.dto;

import com.example.project1.data.domain.IslandEntity;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IslandDTO {
    private Long islandId;
    private String islandName;
    private AddressDTO address;
}
