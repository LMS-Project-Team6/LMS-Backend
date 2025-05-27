package com.group6.lmsbackend.mapper;

import com.group6.lmsbackend.vo.Lib;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LibMapper {

    public int save(Lib l);

    Lib selectByLibId(String libId);
}
