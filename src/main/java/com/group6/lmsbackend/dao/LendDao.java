package com.group6.lmsbackend.dao;

import com.group6.lmsbackend.mapper.LendMapper;
import com.group6.lmsbackend.vo.Book;
import com.group6.lmsbackend.vo.LendReturn;
import com.group6.lmsbackend.vo.Mem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class LendDao {



    @Autowired
    private LendMapper lendMapper;

    // 회원의 대출 중인 도서 수 반환
    public int getActiveLoanCount(String memId) {
        return lendMapper.countActiveLoans(memId);
    }

    // 특정 도서가 대출 중인지 여부 (0: 대출 가능, 1 이상: 대출 중)
    public boolean isBookOnLoan(String bookId) {
        return lendMapper.countBookActiveLoan(bookId) > 0;
    }

    // 대출 정보 등록
    public void insertLendRecord(LendReturn lendReturn) {
        lendMapper.insertLend(lendReturn);
    }

    // 연체 처리 (대출일 + 14일 지난 경우 overNY = 1)
    public void updateOverdueStatus(LocalDate thresholdDate) {
        lendMapper.markOverdue(thresholdDate);
    }

    public void markBookAsLent(String bookId) {
        lendMapper.updateBookLendStatus(bookId);
    }

    public List<Mem> searchMembers(String category, String keyword) {
        return lendMapper.searchMembers(category, keyword);
    }

    public List<Book> searchBooks(String category, String keyword) {
        return lendMapper.searchBooks(category, keyword);
    }
}

