package com.youn.have.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Set;

@Data
@Getter
@Setter
public class UserDTO {

    @NotBlank
    private Integer id;

    private String name;

    private Integer age;

    private Set<PhoneDTO> phoneSet;

}
