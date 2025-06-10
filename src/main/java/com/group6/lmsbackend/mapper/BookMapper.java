package com.group6.lmsbackend.mapper;

import com.group6.lmsbackend.vo.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BookMapper {

    public int deleteBookById(String bookId);

    List<Book> findAll();

    public int addBook(Book book);

    public int updateBook(Book book);

    public Book getBookDetails(String bookId);

    public List<Book> searchBooks(Map<String, Object> params);

}
