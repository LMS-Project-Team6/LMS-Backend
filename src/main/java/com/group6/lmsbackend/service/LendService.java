package com.group6.lmsbackend.service;

import com.group6.lmsbackend.dao.LendDao;
import com.group6.lmsbackend.mapper.LendMapper;
import com.group6.lmsbackend.vo.LendReturn;
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
        if (memId == null || memId.isBlank()) {
            return false;
        }

        if (bookIds == null || bookIds.isEmpty()) {
            return false;
        }

        int currentLoans = lendDao.getActiveLoanCount(memId);  // DAO 메서드 사용
        int available = MAX_LOANS - currentLoans;
        if (available < bookIds.size()) {
            return false;
        }

        LocalDate now = LocalDate.now();

        for (String bookId : bookIds) {
            if (lendDao.isBookOnLoan(bookId)) {  // DAO 메서드 사용
                return false;
            }
        }

        for (String bookId : bookIds) {
            LendReturn lend = new LendReturn();
            lend.setMemId(memId);
            lend.setBookId(bookId);
            lend.setLendDate(now.toString());
            lend.setReturnNY(0);
            lend.setOverNY(0);
            lendDao.insertLendRecord(lend);  // DAO 메서드 사용
        }

        return true;
    }
}
