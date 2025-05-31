package com.group6.lmsbackend.service;

import com.group6.lmsbackend.dao.BookDao;
import com.group6.lmsbackend.vo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public int addBook(Book book) { return bookDao.addBook(book); }

    public int updateBook(Book book) { return bookDao.updateBook(book); }

    public Book getBookDetails(String bookId) { return bookDao.getBookDetails(bookId); }

    public List<Book> searchBooks(String searchType, String searchValue) { return bookDao.searchBooks(searchType, searchValue); }

}
