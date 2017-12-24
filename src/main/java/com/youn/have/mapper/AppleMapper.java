package com.youn.have.mapper;

import com.youn.have.dto.AppleDTO;
import com.youn.have.entity.Apple;
import com.youn.have.vo.AppleVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Map;

//@Mapper(componentModel = "spring")  Mapper实现类会被加上@Component注解，被spring容器管理
@Mapper
public interface AppleMapper {

    AppleMapper INSTANCE = Mappers.getMapper(AppleMapper.class);

    @Mapping(source = "count", target = "number")
    AppleDTO appleToAppleDTO(Apple apple);

    @Mapping(source = "count", target = "number")
    AppleVO appleToAppleVO(Apple apple);

    @Mapping(source = "number", target = "count")
    Apple dtoToEntity(AppleDTO appleDTO);

//    @Mapping(source = "number", target = "count")
    Apple mapToEntity(Map<String, Object> appleMap);

}
