package com.group6.lmsbackend.service;

import com.group6.lmsbackend.dao.MemDao;
import com.group6.lmsbackend.vo.Mem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemService {

    @Autowired
    MemDao memDao;

    public List<Mem> getAllMems() { return memDao.getAllMems(); }

    public int memAdd(Mem mem) {
        return memDao.memAdd(mem);
    }

    public int memUpdate(Mem mem) {return memDao.memUpdate(mem);}

    public List<Mem> memSearch(Mem mem) {return memDao.memSearch(mem);}

    public Mem getMemberByMemId(String memId) {return memDao.findByMemId(memId);}

    public List<Mem> searchMembers(String category, String keyword) {
        return memDao.searchMembers(category, keyword);
    }

}