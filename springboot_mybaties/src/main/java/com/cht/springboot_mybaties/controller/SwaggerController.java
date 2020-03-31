package com.cht.springboot_mybaties.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/swagger")
@CrossOrigin
@Api("swaggerTest")
public class SwaggerController {
	
	@GetMapping("/get")
	@ApiOperation("测试get方法")
	@ApiImplicitParams({
		  @ApiImplicitParam(name="username",value="用户名",defaultValue="zhangsan",required=true),
		  @ApiImplicitParam(name="password",value="密码",defaultValue="",required=true)
		  })
	public void get(@RequestParam String name,@RequestParam String password) {
		
	}

}
