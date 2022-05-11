package com.empl.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ManagmentSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagmentSystemApplication.class, args);
	}

}
