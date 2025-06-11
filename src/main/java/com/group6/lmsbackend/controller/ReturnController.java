package com.group6.lmsbackend.controller;

import com.group6.lmsbackend.service.ReturnService;
import com.group6.lmsbackend.vo.Book;
import com.group6.lmsbackend.vo.LendReturn;
import com.group6.lmsbackend.vo.Mem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("return")
public class ReturnController {

    @Autowired
    private ReturnService returnService;

    // 반납되지 않은 도서 리스트
    @GetMapping("/findAllNotReturn")
    public List<LendReturn> findAllNotReturn() {
        return returnService.findAllNotReturn();
    }

    // 도서 ID로 직접 반납 처리
    @PostMapping("books")
    public ResponseEntity<Boolean> returnBooks(@RequestBody List<String> bookIds) {
        boolean success = returnService.returnBooks(bookIds);
        return ResponseEntity.ok(success);
    }
}