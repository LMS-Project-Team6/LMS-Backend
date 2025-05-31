package com.group6.lmsbackend.mapper;

import com.group6.lmsbackend.vo.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper {

    public int addBook(Book book);

}
