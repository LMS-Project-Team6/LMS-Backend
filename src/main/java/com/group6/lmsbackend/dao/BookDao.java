package com.group6.lmsbackend.dao;

import com.group6.lmsbackend.mapper.BookMapper;
import com.group6.lmsbackend.vo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {

    @Autowired
    private BookMapper bookMapper;

    public int addBook(Book book) { return bookMapper.addBook(book); }

    public int updateBook(Book book) { return bookMapper.updateBook(book); }

}
