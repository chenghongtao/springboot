package com.cht.springboot_mybaties.task;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;

/**
 * 基于接口实现定时任务
 * @author Administrator
 *
 */
//@Component
public class TaskByInterFace implements SchedulingConfigurer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TaskByInterFace.class);

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.addCronTask(new Runnable() {
			
			@Override
			public void run() {
				LOGGER.info(String.valueOf(new Date().getTime()));
			}
		}, "* * * * * *");
		
	}

}
