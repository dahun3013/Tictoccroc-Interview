package com.example.project1.data.mapper;

import com.example.project1.data.domain.HistoryEntity;
import com.example.project1.data.dto.HistoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface HistoryMapper {
    HistoryMapper INSTANCE = Mappers.getMapper(HistoryMapper.class);
    HistoryDTO toDTO(HistoryEntity history);
    HistoryEntity toEntity(HistoryDTO historyDTO);
}
