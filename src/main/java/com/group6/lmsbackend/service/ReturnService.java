package com.group6.lmsbackend.service;

import com.group6.lmsbackend.dao.ReturnDao;
import com.group6.lmsbackend.vo.Book;
import com.group6.lmsbackend.vo.LendReturn;
import com.group6.lmsbackend.vo.Mem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Map;

@Service
public class ReturnService {

    @Autowired
    private ReturnDao returnDao;

    public List<LendReturn> searchLendBooks(String searchType, String searchValue) {
        return returnDao.searchLendBooks(searchType, searchValue);
    }

    public List<LendReturn> findAllNotReturn() { return returnDao.findAllNotReturn(); }

    @Transactional
    public boolean returnBooks(List<String> bookIds) {
        if (bookIds == null || bookIds.isEmpty()) return false;

        int updated = returnDao.returnBooksByBookIds(bookIds);

        if (updated > 0) {
            for (String bookId : bookIds) {
                returnDao.markBookAsReturn(bookId);
            }
            return true;
        }

        return false;
    }
}