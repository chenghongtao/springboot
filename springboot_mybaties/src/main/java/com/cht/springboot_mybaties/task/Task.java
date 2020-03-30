package com.cht.springboot_mybaties.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class Task {
	
	//@Autowired
	//private WebSocketServer server=new WebSocketServer();
	
	private static int NUM=0;
	
	//@Scheduled(fixedRate = 2000)
    public void testTasks() {
		
		System.out.println("执行任务:"+(NUM++));
		//WebSocketServer.sendInfo("server return data");
    }
}
