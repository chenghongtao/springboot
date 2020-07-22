package com.cht.springboot_mybaties.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cht.springboot_mybaties.config.WebSocketServer;
import com.cht.springboot_mybaties.model.Book;
import com.cht.springboot_mybaties.service.BookService;

@Service("bookService")
public class BookServiceImpl implements BookService {

	@Autowired
	private WebSocketServer server;

	@Override
	public Map<String, Object> commonMethod() {

		//构造数据
		List<Book> list = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			Book book = new Book();
			book.setId(i);
			book.setPrice(i * 10);
			book.setTitle("JAVA 编程思想第" + i + "版");
			list.add(book);
		}
		
		// excel标题
		String[] title = { "ID", "价格", "标题"};
		
		// excel文件名
		String fileName = "JAVA 编程思想" + System.currentTimeMillis() + ".xls";
		
		//sheet名称
		String sheetName="书籍价格表";
				
		String[][] content= new String[list.size()][title.length];
		
		for (int i = 0; i < list.size(); i++) {
            content[i] = new String[title.length];
            
            Book obj = list.get(i);
            
            content[i][0]=String.valueOf(obj.getId());
            
            content[i][1]=String.valueOf(obj.getPrice());
            
            content[i][1]=obj.getTitle();
           
		}

		Map<String,Object> map=new HashMap<>();
		map.put("title",title);
		map.put("fileName",fileName);
		map.put("sheetName",sheetName);
		map.put("content",content);
		
		return map;
	}

	@Override
	@Scheduled(fixedRate = 2000)
	public void socket() {
		server.sendMessage(String.valueOf(System.currentTimeMillis()));
	}

}
