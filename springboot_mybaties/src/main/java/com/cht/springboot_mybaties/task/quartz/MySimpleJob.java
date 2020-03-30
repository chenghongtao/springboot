package com.cht.springboot_mybaties.task.quartz;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class MySimpleJob {
	
	public void task() {
		System.out.println("----------------------------"+new Date());
	}

}
