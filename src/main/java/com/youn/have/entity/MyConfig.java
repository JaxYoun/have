package com.youn.have.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@Setter
@Getter
@ConfigurationProperties(prefix = "my.config")
public class MyConfig {

    private String id;

    private String name;
}
