package com.group6.lmsbackend.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReturnMapper {
    List<Map<String, Object>> findLoanedBooks(String memId);

    int returnBooks(Map<String, Object> param);
}


