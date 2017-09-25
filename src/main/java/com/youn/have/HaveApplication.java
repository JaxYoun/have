package com.youn.have;

import com.youn.have.entity.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({MyConfig.class})
public class HaveApplication {

	public static void main(String[] args) {
		SpringApplication.run(HaveApplication.class, args);
	}

}
