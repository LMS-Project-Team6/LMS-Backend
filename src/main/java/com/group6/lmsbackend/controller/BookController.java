package com.group6.lmsbackend.controller;

import com.group6.lmsbackend.service.BookService;
import com.group6.lmsbackend.vo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "book")
public class BookController {

    @Autowired
    private BookService bookService;

    //도서 추가
    @PostMapping("addBook")
    public ResponseEntity<?> addBook(
            @RequestParam(value="bookId") String bookId,
            @RequestParam(value="bookTitle") String bookTitle,
            @RequestParam(value="bookWriter") String bookWriter,
            @RequestParam(value="bookPublisher") String bookPublisher,
            @RequestParam(value="bookCNum") String bookCNum,
            @RequestParam(value="lendNY") Integer lendNY
    ){
        Book book = new Book();

        book.setBookId(bookId);
        book.setBookTitle(bookTitle);
        book.setBookWriter(bookWriter);
        book.setBookPublisher(bookPublisher);
        book.setBookCNum(bookCNum);
        book.setLendNY(lendNY);

        bookService.addBook(book);

        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    //도서 수정
    @PutMapping("updateBook")
    public ResponseEntity<?> updateBook(
            @RequestParam(value="bookId") String bookId,
            @RequestParam(value="bookTitle") String bookTitle,
            @RequestParam(value="bookWriter") String bookWriter,
            @RequestParam(value="bookPublisher") String bookPublisher,
            @RequestParam(value="bookCNum") String bookCNum
    ){
        Book book = new Book();

        book.setBookId(bookId);
        book.setBookTitle(bookTitle);
        book.setBookWriter(bookWriter);
        book.setBookPublisher(bookPublisher);
        book.setBookCNum(bookCNum);

        bookService.updateBook(book);

        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }
}
