package com.example.bookstoreapp.data_manager.model;

public class BookModel {
    private String bookTitle;
    private String bookAuthor;
    private String  bookID;

    public BookModel(String bookID, String bookTitle, String bookAuthor) {
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
    }

    public BookModel(BookResponseModel bookResponseModel) {
        this.bookID = bookResponseModel.getBookID();
        this.bookTitle = bookResponseModel.getBookTitle();
        this.bookAuthor = bookResponseModel.getBookAuthor();
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public BookModel(){
    }
}
