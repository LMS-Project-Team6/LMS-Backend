package com.group6.lmsbackend.mapper;

import com.group6.lmsbackend.vo.Lib;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LibMapper {

    public int save(Lib l);

    Lib login(@Param("libId") String libId, @Param("libPw") String libPw);

}
