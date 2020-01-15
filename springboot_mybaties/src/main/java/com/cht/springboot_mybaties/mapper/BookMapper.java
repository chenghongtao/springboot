package com.cht.springboot_mybaties.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cht.springboot_mybaties.model.Book;

@Mapper
public interface BookMapper {
   public List<Book> getAllBooks();
   
   public List<Book> getBooks();
}
