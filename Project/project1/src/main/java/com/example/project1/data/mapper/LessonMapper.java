package com.example.project1.data.mapper;

import com.example.project1.data.domain.LessonEntity;
import com.example.project1.data.dto.LessonDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface LessonMapper {
    LessonMapper INSTANCE = Mappers.getMapper(LessonMapper.class);
    LessonDTO toDTO(LessonEntity lesson);
    LessonEntity toEntity(LessonDTO lessonDTO);
}