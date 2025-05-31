package com.group6.lmsbackend.vo;

public class Mem {
    private String memId="";
    private String memName=null;
    private String memEmail=null;
    private String memBirth=null;
    private String memPNum=null;
    private String createdDate=null;
    private String modifiedDate=null;

    public String getMemId() {
        return memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }

    public String getMemName() {
        return memName;
    }

    public void setMemName(String memName) {
        this.memName = memName;
    }

    public String getMemEmail() {
        return memEmail;
    }

    public void setMemEmail(String memEmail) {
        this.memEmail = memEmail;
    }

    public String getMemBirth() {
        return memBirth;
    }

    public void setMemBirth(String memBirth) {
        this.memBirth = memBirth;
    }

    public String getMemPNum() {
        return memPNum;
    }

    public void setMemPNum(String memPNum) {
        this.memPNum = memPNum;
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
