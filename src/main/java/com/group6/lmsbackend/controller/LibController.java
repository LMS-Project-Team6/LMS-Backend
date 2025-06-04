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

@Controller
@RequestMapping(value = "lib")
public class LibController {

    @Autowired
    LibService libService;

    // ✅ 1. 아이디 중복 확인 (추가된 메서드)
    @PostMapping("checkLibId")
    public ResponseEntity<Boolean> checkLibId(@RequestParam("libId") String libId) {
        boolean isDuplicate = libService.isLibIdDuplicate(libId);
        return new ResponseEntity<>(isDuplicate, HttpStatus.OK);
    }

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
        if(libService.isLibIdDuplicate(libId)) {
            return new ResponseEntity<>("이미 사용 중인 아이디입니다.", HttpStatus.CONFLICT);
        }

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

    //사서 로그인
    @PostMapping("login")
    public ResponseEntity<?> login(
            @RequestParam(value="libId") String libId,
            @RequestParam(value="libPw") String libPw) {

        Lib lib = new Lib();
        lib.setLibId(libId);
        lib.setLibPw(libPw);

        Lib l = libService.login(lib);

        if (l != null) {
            if (l.getAdminNY() == 1) {
                return new ResponseEntity<>("관리자 입니다.", HttpStatus.OK);
            } else if (l.getAdminNY() == 0) {
                return new ResponseEntity<>("사서 입니다.", HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>("잘못 설정 되어 있습니다.", HttpStatus.UNAUTHORIZED);
            }
        } else {
            return new ResponseEntity<>("아이디 또는 비밀번호가 틀렸습니다.", HttpStatus.UNAUTHORIZED);
        }
    }

}