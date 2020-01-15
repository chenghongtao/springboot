package com.cht.springboot_mybaties.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cht.springboot_mybaties.model.LibEntity;
import com.cht.springboot_mybaties.model.Person;
import com.cht.springboot_mybaties.service.BookService;
import com.cht.springboot_mybaties.util.ResultUtils;

@RestController
@RequestMapping("/hello")
public class HelloController {

	@Autowired
	private BookService bookService;

	@RequestMapping("/say")
	public String hello() {
//		List<Book> books = bookService.getAllBooks();
//		System.out.println(books);
		return "hello";
	}

	@PostMapping("/test")
	public ResultUtils test(@RequestBody LibEntity[] libs) {
		ResultUtils result = new ResultUtils<LibEntity>();
		for (LibEntity lib : libs) {
			System.out.println(lib.getBook());
			List<Person> authors = lib.getAuthors();
			for (Person author : authors) {
				System.out.println("------" + author.getName() + ":" + author.getAge());
			}
		}
		result.setMessage("success");
		result.setData(libs);
		result.setStatus(200);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("one", 1);
		result.setExt(map);
		return result;
	}
}
