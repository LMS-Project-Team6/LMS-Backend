package com.group6.lmsbackend.mapper;

import com.group6.lmsbackend.vo.Book;
import com.group6.lmsbackend.vo.LendReturn;
import com.group6.lmsbackend.vo.Mem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface LendMapper {

    List<Mem> searchMembers(@Param("category") String category, @Param("keyword") String keyword);

    List<Book> searchBooks(@Param("category") String category, @Param("keyword") String keyword);

    void updateBookLendStatus(@Param("bookId") String bookId);

    // 회원의 returnNY = 0인 대출 수
    int countActiveLoans(@Param("memId") String memId);

    // 특정 도서가 returnNY = 0 상태인지 확인
    int countBookActiveLoan(@Param("bookId") String bookId);

    // LendReturn 테이블에 insert
    void insertLend(LendReturn lend);

    // 14일 이상 지난 모든 대출에 overNY = 1 업데이트
    void markOverdue(@Param("threshold") LocalDate threshold);
}

