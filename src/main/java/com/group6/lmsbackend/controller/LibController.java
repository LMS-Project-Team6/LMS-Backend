package com.group6.lmsbackend.controller;

import com.group6.lmsbackend.service.LibService;
import com.group6.lmsbackend.vo.Lib;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.print.attribute.standard.DateTimeAtCreation;

@Controller
@RequestMapping(value = "lib")
public class LibController {

    @Autowired
    LibService libService;

    // 사서 회원가입
    @PostMapping("save")
    public ResponseEntity<?> save(
            @RequestParam(value="libId") String libId,
            @RequestParam(value="libName") String libName,
            @RequestParam(value="libPw") String libPw,
            @RequestParam(value="libEmail") String libEmail,
            @RequestParam(value="libPNum") String libPNum,
            @RequestParam(value="libBirth") String libBirth,
            @RequestParam(value="adminNY") Integer adminNY,
            @RequestParam(value="applyNY") Integer applyNY
    ){
        Lib l=new Lib();

        l.setLibId(libId);
        l.setLibName(libName);
        l.setLibPw(libPw);
        l.setLibEmail(libEmail);
        l.setLibPNum(libPNum);
        l.setLibBirth(libBirth);
        l.setAdminNY(adminNY);
        l.setApplyNY(applyNY);

        libService.save(l);

        return new ResponseEntity<Lib>(l, HttpStatus.OK);
    }

}