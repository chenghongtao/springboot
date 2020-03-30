package com.cht.springboot_mybaties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling  //定时器相关注解
public class Application 
{
    public static void main( String[] args )
    {
        SpringApplication.run(Application.class, args);
       
    }
}
