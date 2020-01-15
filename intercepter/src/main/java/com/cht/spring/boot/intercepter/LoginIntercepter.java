package com.cht.spring.boot.intercepter;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoginIntercepter implements HandlerInterceptor{
	
	private Logger logger=LoggerFactory.getLogger(LoginIntercepter.class);
	
	private long startTime=0L;
	
	private long endTime=0L;
	
	private static SimpleDateFormat FORMATTER=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	//在请求处理之前进行调用（Controller方法调用之前）
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Date start=new Date();
		logger.info(request.getRequestURI()+"----start---"+FORMATTER.format(start));
		this.startTime=start.getTime();
		if("admin".equals(request.getParameter("username"))) {
			return true;
		}
		return false;
	}
	
	//请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
		Date end=new Date();
		logger.info(request.getRequestURI()+"----end---------"+FORMATTER.format(end));
		this.endTime=end.getTime();
		logger.info("总共耗时----------------------------->"+(this.endTime-this.startTime)+"ms");
	}
	
	//在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
		//System.out.println("渲染之后-----"+FORMATTER.format(new Date()));
	}

}
