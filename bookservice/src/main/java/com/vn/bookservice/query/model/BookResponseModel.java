package com.vn.bookservice.query.model;

public class BookResponseModel {

    private String id;
    private String name;
    private String author;
    private Boolean isReady;

    public BookResponseModel(String id, String name, String author, Boolean isReady) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.isReady = isReady;
    }
    public BookResponseModel() {}

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public Boolean getIsReady() {
        return isReady;
    }
    public void setIsReady(Boolean isReady) {
        this.isReady = isReady;
    }

}
