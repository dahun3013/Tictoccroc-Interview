package com.example.project1.DTO;

import com.example.project1.domain.ParentEntity;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ParentDTO {
    private Long parentId;
    private String email;
    private String parentName;

    public ParentEntity toEntity(){
        return ParentEntity.builder()
                .id(parentId)
                .email(email)
                .parentName(parentName)
                .build();
    }
}
