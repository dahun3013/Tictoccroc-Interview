package com.example.project1.data.mapper;

import com.example.project1.data.domain.ParentEntity;
import com.example.project1.data.dto.ParentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface ParentMapper {
    ParentMapper INSTANCE = Mappers.getMapper(ParentMapper.class);
    ParentDTO toDTO(ParentEntity parent);
    ParentEntity toEntity(ParentDTO parentDTO);
}