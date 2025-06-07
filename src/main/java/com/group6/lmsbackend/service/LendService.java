package com.group6.lmsbackend.service;

import com.group6.lmsbackend.dao.LendDao;
import com.group6.lmsbackend.mapper.LendMapper;
import com.group6.lmsbackend.vo.Book;
import com.group6.lmsbackend.vo.LendReturn;
import com.group6.lmsbackend.vo.Mem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LendService {

    @Autowired
    private LendDao lendDao;

    private static final int MAX_LOANS = 5;

    public boolean lendBooks(String memId, List<String> bookIds) {
        if (memId == null || memId.isBlank() || bookIds == null || bookIds.isEmpty()) {
            return false;
        }

        int currentLoans = lendDao.getActiveLoanCount(memId);
        int available = MAX_LOANS - currentLoans;
        if (available < bookIds.size()) {
            return false;
        }

        LocalDate now = LocalDate.now();

        for (String bookId : bookIds) {
            if (lendDao.isBookOnLoan(bookId)) {
                return false; // 이미 대출 중인 책
            }
        }

        for (String bookId : bookIds) {
            LendReturn lend = new LendReturn();
            lend.setMemId(memId);
            lend.setBookId(bookId);
            lend.setLendDate(now.toString());
            lend.setReturnNY(0);
            lend.setOverNY(0);
            lendDao.insertLendRecord(lend);
            lendDao.markBookAsLent(bookId); // book.lendNY = 1 설정
        }

        return true;
    }

    public List<Mem> searchMembers(String category, String keyword) {
        return lendDao.searchMembers(category, keyword);
    }

    public List<Book> searchBooks(String category, String keyword) {
        return lendDao.searchBooks(category, keyword);
    }
}
