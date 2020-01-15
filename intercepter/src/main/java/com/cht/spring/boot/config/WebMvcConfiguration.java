package com.cht.spring.boot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cht.spring.boot.intercepter.LoginIntercepter;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
	
	//引入拦截器
	@Autowired
	private LoginIntercepter loginIntercepter;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		//分别指定拦截器和拦截路径(可以添加多个拦截器和拦截路径)
		registry.addInterceptor(loginIntercepter).addPathPatterns("/login/*");
		
		//添加第二个拦截器
		//registry.addInterceptor(IntercepterName).addPathPatterns("/other")
	}
	

}
