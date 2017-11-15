package com.youn.have.entity;

import com.youn.have.dto.AppleDTO;
import com.youn.have.enume.AppleColor;
import com.youn.have.mapper.AppleMapper;
import com.youn.have.vo.AppleVO;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Apple {

    private String id;

    private String name;

    private Integer count;

    private AppleColor appleColor;

}

class MyUtil {

    public static void mapperToDTO() {
        Apple apple = new Apple("75", "杨建雄", Integer.valueOf(29), AppleColor.GREEN);
        AppleDTO appleDTO = AppleMapper.INSTANCE.appleToAppleDTO(apple);

        System.out.println(appleDTO.getAppleColor());
        System.out.println(appleDTO.getId());
        System.out.println(appleDTO.getName());
        System.out.println(appleDTO.getNumber());
    }

    public static void mapperToVO() {
        Apple apple = new Apple("75", "杨建雄", Integer.valueOf(29), AppleColor.GREEN);
        AppleVO appleVO = AppleMapper.INSTANCE.appleToAppleVO(apple);

        System.out.println(appleVO.getAppleColor());
        System.out.println(appleVO.getId());
        System.out.println(appleVO.getName());
        System.out.println(appleVO.getNumber());
    }

    public static void enumTest() {
        System.out.println(AppleColor.GREEN.name());
        System.out.println(AppleColor.valueOf("RED"));
    }

    public static void main(String[] args) {
//        mapperToDTO();
//        enumTest();
        mapperToVO();
    }

}
