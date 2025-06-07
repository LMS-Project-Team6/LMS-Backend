package com.group6.lmsbackend.service;

import com.group6.lmsbackend.dao.ReturnDao;
import com.group6.lmsbackend.vo.Mem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReturnService {

    @Autowired
    private ReturnDao returnDao;

    public List<Map<String, Object>> getLoanedBooks(String memId) {
        return returnDao.findLoanedBooks(memId);
    }

    public boolean returnBooks(String memId, List<String> bookIds) {
        if (memId == null || memId.isBlank() || bookIds == null || bookIds.isEmpty()) {
            return false;
        }
        int updated = returnDao.returnBooks(memId, bookIds);
        return updated > 0;
    }

    public List<Mem> searchMembers(String category, String keyword) {
        return returnDao.searchMembers(category, keyword);
    }

}
