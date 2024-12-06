package com.vn.bookservice.query.queries;

public class GetBookById {
    private String id;
    public GetBookById(String id) {
        this.id = id;
    }
    public GetBookById() {}
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

}
