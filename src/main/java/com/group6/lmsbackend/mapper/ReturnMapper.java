package com.group6.lmsbackend.mapper;

import com.group6.lmsbackend.vo.Book;
import com.group6.lmsbackend.vo.LendReturn;
import com.group6.lmsbackend.vo.Mem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReturnMapper {

    List<LendReturn> findAllNotReturn();

    int returnBooksByBookIds(@Param("bookIds") List<String> bookIds);

    void updateBookReturnStatus(@Param("bookId") String bookId);

}