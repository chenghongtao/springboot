package com.cht.springboot_mybaties.task.quartz;

import java.util.Date;

import org.quartz.JobDataMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

@Configuration
public class QuartzConfig {
	
	/**
	 *这种可以直接指定目标Bean的名称和目标方法的名字，不支持传参
	 * @return
	 */
	@Bean
	MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean() {
		MethodInvokingJobDetailFactoryBean bean=new MethodInvokingJobDetailFactoryBean();
		bean.setTargetBeanName("mySimpleJob");
		bean.setTargetMethod("task");
		return bean;
	}
	
	/**
	 * 这种可以配置JobDetail，任务类继承QuartzJobBean，该参数支持传参，将参数封装再JobDataMap中
	 * @return
	 */
	@Bean
	JobDetailFactoryBean jobDetailFactoryBean() {
		JobDetailFactoryBean bean=new JobDetailFactoryBean();
		bean.setJobClass(MyJob.class);    //指定job的类名.class
		JobDataMap map=new JobDataMap();  //存放参数
		map.put("helloService",StaticMethodGetBean.getBean(HelloService.class));   //key必须和MyJob中的属性变量名称相同
		bean.setJobDataMap(map);
		return bean;
	}
	
	//触发器(SimpleTriggerFactoryBean)类似于@Scheduler的基本用法
	@Bean
	SimpleTriggerFactoryBean simpleTriggerFactoryBean() {
		SimpleTriggerFactoryBean bean=new SimpleTriggerFactoryBean();
		bean.setStartTime(new Date());   //设置开始时间
		bean.setRepeatCount(-1);   //-1 表示无限次   重复执行次数
		bean.setJobDetail(methodInvokingJobDetailFactoryBean().getObject());  //设置任务数据
		bean.setRepeatInterval(3000);   //设置执行间隔为3s
		return bean;  
	}
	
	//触发器，类似于@Scheduler中的cron表达式的用法
	@Bean
	CronTriggerFactoryBean cronTriggerFactoryBean() {
		CronTriggerFactoryBean bean=new CronTriggerFactoryBean();
		bean.setCronExpression("0/5 * * * * ? *");   //每五秒执行一次
		bean.setJobDetail(jobDetailFactoryBean().getObject());
		return bean;
	}
	
	//定义一个调度器，并且将触发器设置到调度器中
	@Bean
	SchedulerFactoryBean schedulerFactoryBean() {
		SchedulerFactoryBean bean = new SchedulerFactoryBean();
		//设置触发器
		bean.setTriggers(cronTriggerFactoryBean().getObject(),simpleTriggerFactoryBean().getObject());
		return bean;
	}

}
