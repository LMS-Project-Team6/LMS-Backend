package com.group6.lmsbackend.dao;

import com.group6.lmsbackend.mapper.ReturnMapper;
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

    public List<Map<String, Object>> findLoanedBooks(String memId) {
        return returnMapper.findLoanedBooks(memId);
    }

    public int returnBooks(String memId, List<String> bookIds) {
        Map<String, Object> param = new HashMap<>();
        param.put("memId", memId);
        param.put("bookIds", bookIds);
        return returnMapper.returnBooks(param);
    }

    public List<Mem> searchMembers(String category, String keyword) {
        return returnMapper.searchMembers(category, keyword);
    }

}
