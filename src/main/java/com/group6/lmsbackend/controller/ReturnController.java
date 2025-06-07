package com.group6.lmsbackend.controller;

import com.group6.lmsbackend.service.ReturnService;
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

    @GetMapping("searchMembers")
    public ResponseEntity<?> searchMembers(
            @RequestParam String category,
            @RequestParam String keyword) {
        List<Mem> members = returnService.searchMembers(category, keyword);
        if (members.isEmpty()) {
            return ResponseEntity.ok("검색 결과가 없습니다.");
        }
        return ResponseEntity.ok(members);
    }



    // 대출 중 도서 조회
    @GetMapping("loanedBooks")
    public ResponseEntity<?> getLoanedBooks(@RequestParam String memId) {
        List<Map<String, Object>> loanedBooks = returnService.getLoanedBooks(memId);
        if (loanedBooks.isEmpty()) {
            return ResponseEntity.ok("대출 중인 도서가 없습니다.");
        }
        return ResponseEntity.ok(loanedBooks);
    }

    // 도서 반납 처리
    @PostMapping("books")
    public ResponseEntity<Boolean> returnBooks(
            @RequestParam String memId,
            @RequestBody List<String> bookIds) {
        boolean success = returnService.returnBooks(memId, bookIds);
        return ResponseEntity.ok(success);
    }
}
