package com.cht.springboot_mybaties.task.quartz;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * spring boot中获取注入的bean对象
 * 
 * @author 程红涛
 *
 */
@Component
public class StaticMethodGetBean implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		StaticMethodGetBean.applicationContext = applicationContext;
	}

	public static <T> T getBean(Class<T> clazz) {
		return applicationContext == null ? null : applicationContext.getBean(clazz);
	}

}
