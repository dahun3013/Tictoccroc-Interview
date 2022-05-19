package com.example.project1.data.mapper;

import com.example.project1.data.domain.ReservationEntity;
import com.example.project1.data.dto.ReservationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface ReservationMapper {
    ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);
    ReservationDTO toDTO(ReservationEntity reservation);
    ReservationEntity toEntity(ReservationDTO reservationDTO);
}
