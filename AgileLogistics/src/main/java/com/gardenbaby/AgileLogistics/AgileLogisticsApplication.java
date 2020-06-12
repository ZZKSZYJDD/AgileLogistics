package com.gardenbaby.AgileLogistics;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.gardenbaby.AgileLogistics.dao")
@SpringBootApplication
public class AgileLogisticsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgileLogisticsApplication.class, args);
	}

}
