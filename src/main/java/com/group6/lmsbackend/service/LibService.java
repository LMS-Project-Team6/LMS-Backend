package com.group6.lmsbackend.service;

import com.group6.lmsbackend.dao.LibDao;
import com.group6.lmsbackend.vo.Lib;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibService {

    @Autowired
    LibDao libDao;

    public int save(Lib l){
        return libDao.save(l);
    }

    public Lib login(Lib lib){
        return libDao.login(lib);
    }

    public boolean isLibIdDuplicate(String libId) {return libDao.countByLibId(libId) > 0;}


}
