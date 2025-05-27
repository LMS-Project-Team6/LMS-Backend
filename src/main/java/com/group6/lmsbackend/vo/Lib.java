package com.group6.lmsbackend.vo;

public class Lib {
    private String libId="";
    private String libName=null;
    private String libPw=null;
    private String libEmail=null;
    private String libPNum=null;
    private String libBirth=null;
    private int adminNY=0;
    private int applyNY=0;
    private String createdDate=null;
    private String modifiedDate=null;

    public String getLibId() {
        return libId;
    }

    public void setLibId(String libId) {
        this.libId = libId;
    }

    public String getLibName() {
        return libName;
    }

    public void setLibName(String libName) {
        this.libName = libName;
    }

    public String getLibPw() {
        return libPw;
    }

    public void setLibPw(String libPw) {
        this.libPw = libPw;
    }

    public String getLibEmail() {
        return libEmail;
    }

    public void setLibEmail(String libEmail) {
        this.libEmail = libEmail;
    }

    public String getLibPNum() {
        return libPNum;
    }

    public void setLibPNum(String libPNum) {
        this.libPNum = libPNum;
    }

    public String getLibBirth() {
        return libBirth;
    }

    public void setLibBirth(String libBirth) {
        this.libBirth = libBirth;
    }

    public int getAdminNY() {
        return adminNY;
    }

    public void setAdminNY(int adminNY) {
        this.adminNY = adminNY;
    }

    public int getApplyNY() {
        return applyNY;
    }

    public void setApplyNY(int applyNY) {
        this.applyNY = applyNY;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}