package com.cht.spring.boot.test.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Task {

    //@Scheduled(fixedRate = 2000)
    public void task(){
        System.out.println(System.currentTimeMillis()+"-----------------");
    }
}
