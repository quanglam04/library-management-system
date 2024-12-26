package com.vn.borrowingService.command.model;

import java.util.Date;

public class BorrowingCreateModel {

    private String bookId;
    private String employeeId;
    private Date borrowDate;

    public BorrowingCreateModel(String bookId, String employeeId, Date borrowDate) {
        this.bookId = bookId;
        this.employeeId = employeeId;
        this.borrowDate = borrowDate;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }
}
