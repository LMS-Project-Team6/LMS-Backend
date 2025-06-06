package com.group6.lmsbackend.controller;

import com.group6.lmsbackend.service.LendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController  // ✅ 반드시 추가
@RequestMapping("lend")
public class LendController {

    @Autowired
    private LendService lendService;

    @PostMapping
    public ResponseEntity<Boolean> lendBooks(
            @RequestParam String memId,
            @RequestBody List<String> bookIds
    ) {
        boolean success = lendService.lendBooks(memId, bookIds);
        return ResponseEntity.ok(success); // true or false
    }

}
