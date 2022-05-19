package com.example.project1.data.dto;

import com.example.project1.data.domain.ParentEntity;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ParentDTO {
    private Long parentId;
    private String email;
    private String parentName;
}
