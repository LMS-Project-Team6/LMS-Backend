package com.group6.lmsbackend.dao;

import com.group6.lmsbackend.mapper.BookMapper;
import com.group6.lmsbackend.vo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookDao {

    @Autowired
    private BookMapper bookMapper;

    public boolean deleteBook(String bookId) { return bookMapper.deleteBookById(bookId) > 0; }

    public List<Book> getAllBooks() { return bookMapper.findAll(); }

    public int addBook(Book book) { return bookMapper.addBook(book); }

    public int updateBook(Book book) { return bookMapper.updateBook(book); }

    public Book getBookDetails(String bookId) { return bookMapper.getBookDetails(bookId); }

    public List<Book> searchBooks(String searchType, String searchValue) {
        Map<String, Object> params = new HashMap<>();

        params.put("searchType", searchType);
        params.put("searchValue", searchValue);

        return bookMapper.searchBooks(params);
    }

}
