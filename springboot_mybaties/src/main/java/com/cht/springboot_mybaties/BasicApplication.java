package com.cht.springboot_mybaties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableScheduling  //定时器相关注解
@EnableTransactionManagement
@ComponentScan(basePackages = "com.cht")
public class BasicApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(BasicApplication.class, args);
       
    }
}
