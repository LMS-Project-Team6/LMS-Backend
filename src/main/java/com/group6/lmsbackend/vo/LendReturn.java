package com.group6.lmsbackend.vo;

public class LendReturn {
    private int lendIndex;
    private String memId=null;
    private String bookId=null;
    private String lendDate=null;
    private String returnDate=null;
    private int returnNY=0;
    private int overNY=0;

    public Integer getLendIndex() {
        return lendIndex;
    }

    public void setLendIndex(Integer lendIndex) {
        this.lendIndex = lendIndex;
    }

    public String getMemId() {
        return memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getLendDate() {
        return lendDate;
    }

    public void setLendDate(String lendDate) {
        this.lendDate = lendDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public int getReturnNY() {
        return returnNY;
    }

    public void setReturnNY(int returnNY) {
        this.returnNY = returnNY;
    }

    public int getOverNY() {
        return overNY;
    }

    public void setOverNY(int overNY) {
        this.overNY = overNY;
    }
}
