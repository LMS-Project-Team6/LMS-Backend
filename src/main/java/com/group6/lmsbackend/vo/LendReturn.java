package com.group6.lmsbackend.vo;

public class LendReturn {
    private int lendIndex;
    private String memId=null;
    private String bookId=null;
    private String lendDate=null;
    private String returnDate=null;
    private int returnNY=0;
    private int overNY=0;

    private String bookTitle;  // 책 제목
    private String memName;    // 회원 이름

    public int getLendIndex() { return lendIndex; }

    public void setLendIndex(int lendIndex) { this.lendIndex = lendIndex; }

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

    public String getBookTitle() { return bookTitle; }

    public void setBookTitle(String bookTitle) { this.bookTitle = bookTitle; }

    public String getMemName() { return memName; }

    public void setMemName(String memName) { this.memName = memName; }
}
