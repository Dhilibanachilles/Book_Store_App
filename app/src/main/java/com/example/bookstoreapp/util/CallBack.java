package com.example.bookstoreapp.util;

public interface CallBack<T> {
    void onSuccess(T data);
    void onFailure(Exception exception);
}
