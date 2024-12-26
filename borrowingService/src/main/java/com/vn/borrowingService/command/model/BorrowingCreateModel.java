package com.vn.borrowingService.command.model;

import java.util.Date;

public class BorrowingCreateModel {

    private String bookId;
    private String employeeId;

    public BorrowingCreateModel(String bookId, String employeeId) {
        this.bookId = bookId;
        this.employeeId = employeeId;

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


}
