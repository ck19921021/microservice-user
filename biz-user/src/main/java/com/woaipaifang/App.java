package com.woaipaifang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@MapperScan(basePackages = "com.woaipaifang.mapper")
public class App  {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
