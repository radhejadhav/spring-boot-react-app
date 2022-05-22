package com.empl.system;

import com.empl.system.configurations.MyConfig;
import com.empl.system.configurations.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
@EnableCaching
public class ManagmentSystemApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(ManagmentSystemApplication.class, args);


		ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);


		int s1 = (int) context.getBean("myBean");
		int s2 = (int) context.getBean("myBean");

//		context.st
		System.out.println(context.getStartupDate());
	}

}
