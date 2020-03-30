package com.cht.springboot_mybaties.task.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class MyJob extends QuartzJobBean{
	
	private HelloService helloService;

	public HelloService getHelloService() {
		return helloService;
	}

	public void setHelloService(HelloService helloService) {
		this.helloService = helloService;
	}

	//任务启动，executeInternal方法被执行
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		helloService.task();
	}

}
