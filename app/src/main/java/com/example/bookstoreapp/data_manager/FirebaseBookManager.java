package com.example.bookstoreapp.data_manager;

import android.util.Log;

import com.example.bookstoreapp.data_manager.model.BookModel;
import com.example.bookstoreapp.util.CallBack;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class FirebaseBookManager {
    FirebaseUser firebaseUser;
    FirebaseFirestore firebaseFirestore;
    private static final String TAG = "FirebaseBookManager";

    public void getAllBooks(CallBack<ArrayList<BookModel>> listener) {
        ArrayList<BookModel> bookList = new ArrayList<BookModel>();
        firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("Books").get().addOnSuccessListener(queryDocumentSnapshots -> {
            int i;
            for (i = 0; i < queryDocumentSnapshots.size(); i++) {
                DocumentSnapshot documentSnapshot = queryDocumentSnapshots.getDocuments().get(i);
                Log.e(TAG, "onSuccess: " + documentSnapshot);
                BookModel bookModel = documentSnapshot.toObject(BookModel.class);
                bookList.add(bookModel);
                listener.onSuccess(bookList);
                Log.e(TAG, "Book List" + bookList );
            }
        }).addOnFailureListener(listener::onFailure);
    }
}