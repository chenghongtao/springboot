package com.cht.springboot_mybaties.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cht.springboot_mybaties.util.ResultUtils;

@RestController
@RequestMapping("/request")
@CrossOrigin
public class TestController {

	@PostMapping("/post")
	public ResultUtils<Object> post(@RequestBody Map<String,Object> req){
		ResultUtils<Object> result=new ResultUtils<Object>();
		result.setStatus(1);
		result.setData("post 请求");
		return result;
	}
	
	@GetMapping("/get")
	public ResultUtils<Object> get(@RequestParam String name,@RequestParam int age){
		ResultUtils<Object> result=new ResultUtils<Object>();
		System.out.println(name+"年龄是"+age);
		Person person=new Person();
		person.setAge(age);
		person.setName(name);
		result.setStatus(1);
		result.setData(person);
		return result;
	}

	@PostMapping("/person")
	public ResultUtils<Person> testPost(@RequestBody Person person){
		ResultUtils<Person> result =new ResultUtils<>();
		result.setData(person);
		return result;
	}
	
	
}

class Person{
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}

