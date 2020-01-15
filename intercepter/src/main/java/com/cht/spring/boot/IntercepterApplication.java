package com.cht.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.cht.spring.boot"})
public class IntercepterApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntercepterApplication.class, args);
	}

}
