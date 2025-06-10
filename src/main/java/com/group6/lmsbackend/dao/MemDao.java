package com.group6.lmsbackend.dao;
import com.group6.lmsbackend.mapper.MemMapper;
import com.group6.lmsbackend.vo.Mem;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemDao {
    @Autowired
    private MemMapper memMapper;

    public List<Mem> getAllMems() { return memMapper.findAll(); }

    public int memAdd(Mem mem) {
        return memMapper.memAdd(mem);
    }

    public int memUpdate(Mem mem) {return memMapper.memUpdate(mem);}

    public List<Mem> memSearch(Mem mem) {return memMapper.memSearch(mem);}

    public Mem findByMemId(String memId) {return memMapper.findByMemId(memId);}

    public List<Mem> searchMembers(String category, String keyword) {
        return memMapper.searchMembers(category, keyword);
    }


}
