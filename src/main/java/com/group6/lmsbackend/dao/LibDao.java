package com.group6.lmsbackend.dao;

import com.group6.lmsbackend.mapper.LibMapper;
import com.group6.lmsbackend.vo.Lib;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LibDao {

    @Autowired
    private LibMapper libMapper;

    public int save(Lib l) {
        return libMapper.save(l);
    }
}
