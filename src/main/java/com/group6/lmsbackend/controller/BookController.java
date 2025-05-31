package com.group6.lmsbackend.controller;

import com.group6.lmsbackend.service.BookService;
import com.group6.lmsbackend.vo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //도서 리스트 조회
    @GetMapping("searchBooks")
    public ResponseEntity<?> searchBooks(
            @RequestParam(value="searchType") String searchType,
            @RequestParam(value="searchValue") String searchValue
    ){
        List<Book> books = bookService.searchBooks(searchType, searchValue);

        if (books.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("검색 결과가 없습니다.");
        }
        else {
            return ResponseEntity.ok(books);
        }
    }

    //도서 상세 조회
    @GetMapping("getBookDetails")
    public ResponseEntity<?> getBookDetails(
            @RequestParam(value="bookId") String bookId
    ){
        Book book = bookService.getBookDetails(bookId);

        if (book != null) {
            return new ResponseEntity<Book>(book, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("존재하지 않는 도서입니다.", HttpStatus.NOT_FOUND);
        }
    }
}
