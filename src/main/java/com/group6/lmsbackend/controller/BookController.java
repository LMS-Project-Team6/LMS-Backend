package com.group6.lmsbackend.controller;

import com.group6.lmsbackend.service.BookService;
import com.group6.lmsbackend.vo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "book")
public class BookController {

    @Autowired
    private BookService bookService;

    // 대출 가능한 도서 리스트
    @GetMapping("/findAllAvailability")
    public List<Book> getAvailableBooks() {
        return bookService.findAllAvailability();
    }

    // 도서 삭제
    @DeleteMapping("/deleteBook")
    public ResponseEntity<String> deleteBook(@RequestParam String bookId) {
        try {
            boolean success = bookService.deleteBook(bookId);
            if (success) {
                return ResponseEntity.ok("도서 삭제가 완료되었습니다.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("도서를 찾을 수 없습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace(); // 서버 로그 확인용
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("도서 삭제 중 오류 발생: " + e.getMessage());
        }
    }

    // 도서 리스트
    @GetMapping("findAll")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    //도서 추가
    @PostMapping("addBook")
    public ResponseEntity<?> addBook(
            @RequestParam(value="bookId") String bookId,
            @RequestParam(value="bookTitle") String bookTitle,
            @RequestParam(value="bookWriter") String bookWriter,
            @RequestParam(value="bookPublisher") String bookPublisher,
            @RequestParam(value="bookCNum") String bookCNum,
            @RequestParam(value = "bookIntrd") String bookIntrd,
            @RequestParam(value="lendNY") Integer lendNY
    ){
        Book book = new Book();

        book.setBookId(bookId);
        book.setBookTitle(bookTitle);
        book.setBookWriter(bookWriter);
        book.setBookPublisher(bookPublisher);
        book.setBookCNum(bookCNum);
        book.setBookIntrd(bookIntrd);
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
            @RequestParam(value="bookCNum") String bookCNum,
            @RequestParam(value="bookIntrd") String bookIntrd
    ){
        Book book = new Book();

        book.setBookId(bookId);
        book.setBookTitle(bookTitle);
        book.setBookWriter(bookWriter);
        book.setBookPublisher(bookPublisher);
        book.setBookCNum(bookCNum);
        book.setBookIntrd(bookIntrd);

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
