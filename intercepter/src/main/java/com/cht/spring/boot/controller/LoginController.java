package com.cht.spring.boot.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {

	@GetMapping("/check")
	public String login(@RequestParam("username") String username) {
		System.out.println(username+"------login success");
		return username;
	}
}
