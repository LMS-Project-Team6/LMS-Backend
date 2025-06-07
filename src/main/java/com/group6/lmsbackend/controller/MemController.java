package com.group6.lmsbackend.controller;

import com.group6.lmsbackend.service.MemService;
import com.group6.lmsbackend.vo.Mem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "mem")
public class MemController {

    @Autowired
    MemService memService;

    // 회원 추가
    @PostMapping("memAdd")
    public ResponseEntity<?> memAdd(
            @RequestParam(value="memId") String memId,
            @RequestParam(value="memName") String memName,
            @RequestParam(value = "memEmail") String memEmail,
            @RequestParam(value = "memBirth") String memBirth,
            @RequestParam(value = "memPNum") String memPNum
    ){
        Mem mem = new Mem();

        mem.setMemId(memId);
        mem.setMemName(memName);
        mem.setMemEmail(memEmail);
        mem.setMemBirth(memBirth);
        mem.setMemPNum(memPNum);

        memService.memAdd(mem);

        return new ResponseEntity<Mem>(mem, HttpStatus.OK);
    }

    // 회원 수정
    @PutMapping("memUpdate")
    public ResponseEntity<?> memUpdate(
            @RequestParam(value = "memId") String memId,
            @RequestParam(value = "memName") String memName,
            @RequestParam(value = "memEmail") String memEmail,
            @RequestParam(value = "memBirth") String memBirth,
            @RequestParam(value = "memPNum") String memPNum
    ){
        Mem mem = new Mem();

        mem.setMemId(memId);
        mem.setMemName(memName);
        mem.setMemEmail(memEmail);
        mem.setMemBirth(memBirth);
        mem.setMemPNum(memPNum);

        memService.memUpdate(mem);

        return new ResponseEntity<Mem>(mem, HttpStatus.OK);
    }

    // 회원 조회
    @GetMapping("memSearch")
    public ResponseEntity<?> memSearch(
            @RequestParam(value = "category") String category,
            @RequestParam(value = "keyword") String keyword
    ) {
        List<Mem> members = memService.searchMembers(category, keyword);
        return members.isEmpty()
                ? ResponseEntity.ok("검색 결과가 없습니다.")
                : ResponseEntity.ok(members);
    }



    // 회원 상세 조회
    @GetMapping("memDetail/{memId}")
    public ResponseEntity<Mem> getMemberByMemId(@PathVariable String memId) {
        Mem mem = memService.getMemberByMemId(memId);
        if (mem == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mem);
    }
}
