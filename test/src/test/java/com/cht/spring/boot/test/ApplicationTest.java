package com.cht.spring.boot.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class })
public class ApplicationTest {
	
	@Before
	public void before() {
	   System.out.println("before--------------------");
	}
	
	@After
	public void after() {
	   System.out.println("after--------------------");
	}

	@Test
	public void test() {
		System.out.println("test");
	}
}
