package com.example.project1.data.mapper;

import com.example.project1.data.domain.IslandEntity;
import com.example.project1.data.dto.IslandDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface IslandMapper {
    IslandMapper INSTANCE = Mappers.getMapper(IslandMapper.class);
    IslandDTO toDTO(IslandEntity island);
    IslandEntity toEntity(IslandDTO islandDTO);
}
