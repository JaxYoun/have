package com.youn.have.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Data
@Getter
@Setter
public class UserDTO {

    private Integer id;

    private String name;

    private Integer age;

    private Set<PhoneDTO> phoneSet;

}
