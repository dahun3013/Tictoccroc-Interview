package com.example.project1.data.dto;

import com.example.project1.data.domain.HistoryEntity;
import lombok.*;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HistoryDTO {
    private Long historyId;
    private Date date;
    private ParentDTO parent;
    private LessonDTO lesson;
    private String activity;
}
