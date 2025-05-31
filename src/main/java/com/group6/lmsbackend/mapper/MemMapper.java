package com.group6.lmsbackend.mapper;
import com.group6.lmsbackend.vo.Mem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemMapper {
    public int memAdd(Mem mem);

    public int memUpdate(Mem mem);

    List<Mem> memSearch(Mem mem);
}
