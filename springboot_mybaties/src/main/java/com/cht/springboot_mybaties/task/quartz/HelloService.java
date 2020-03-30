package com.cht.springboot_mybaties.task.quartz;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
	
	public void task() {
		System.out.println("hello-------------service"+new Date());
	}

}
