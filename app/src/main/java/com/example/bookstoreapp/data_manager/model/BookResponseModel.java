package com.example.bookstoreapp.data_manager.model;

public class BookResponseModel {

    private String bookTitle;
    private String bookAuthor;
    private String bookID;

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public BookResponseModel() {
    }

    public BookResponseModel(String bookID, String bookTitle, String bookAuthor) {
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
    }
}