package com.youn.have.mapper;

import com.youn.have.dto.AppleDTO;
import com.youn.have.entity.Apple;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AppleMapper {

    AppleMapper INSTANCE = Mappers.getMapper(AppleMapper.class);

    @Mapping(source = "count", target = "number")
    AppleDTO appleToAppleDTO(Apple apple);

}
