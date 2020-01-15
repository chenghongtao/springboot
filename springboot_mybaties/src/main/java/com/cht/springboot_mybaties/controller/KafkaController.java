package com.cht.springboot_mybaties.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cht.springboot_mybaties.kafka.KafkaProducter;
import com.cht.springboot_mybaties.model.Book;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
	@Autowired
	private KafkaProducter producter;
	
	@GetMapping("/send")
	public String send() {
		Book book=new Book();
		book.setId(1);
		book.setPrice(23.5);
		book.setTitle("java coding");
		producter.sendDataToKafka("config", book);
		return "ok";
	}
	
	
}
