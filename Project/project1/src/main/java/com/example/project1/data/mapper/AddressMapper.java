package com.example.project1.data.mapper;

import com.example.project1.data.domain.AddressEntity;
import com.example.project1.data.dto.AddressDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);
    AddressDTO toDTO(AddressEntity address);
    AddressEntity toEntity(AddressDTO addressDTO);
}
