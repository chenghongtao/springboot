package com.cht.springboot_mybaties.model;

import java.util.List;

public class LibEntity {
	private String book;

	private List<Person> authors;

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public List<Person> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Person> authors) {
		this.authors = authors;
	}

}
