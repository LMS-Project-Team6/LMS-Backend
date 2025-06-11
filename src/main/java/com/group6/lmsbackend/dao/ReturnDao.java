package com.group6.lmsbackend.dao;

import com.group6.lmsbackend.mapper.ReturnMapper;
import com.group6.lmsbackend.vo.Book;
import com.group6.lmsbackend.vo.LendReturn;
import com.group6.lmsbackend.vo.Mem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ReturnDao {

    @Autowired
    private ReturnMapper returnMapper;

    public List<LendReturn> searchLendBooks(String searchType, String searchValue) {
        return returnMapper.searchLendBooks(searchType, searchValue);
    }

    public List<LendReturn> findAllNotReturn() { return returnMapper.findAllNotReturn(); }

    public int returnBooksByBookIds(List<String> bookIds) {
        return returnMapper.returnBooksByBookIds(bookIds);
    }

    public void markBookAsReturn(String bookId) {
        returnMapper.updateBookReturnStatus(bookId);
    }
}