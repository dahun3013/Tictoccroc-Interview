package com.example.project1.DTO;

import com.example.project1.domain.HistoryEntity;
import lombok.*;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class HistoryDTO {
    private Long historyId;
    private Date date;
    private ParentDTO parent;
    private LessonDTO lesson;
    private String activity;

    public HistoryEntity toEntity(){
        return HistoryEntity.builder()
                .id(historyId)
                .date(date)
                .parent(parent.toEntity())
                .lesson(lesson.toEntity())
                .activity(activity)
                .build();
    }
}
