package com.example.bookstoreapp.data_manager.model;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.bookstoreapp.data_manager.FirebaseBookManager;
import com.example.bookstoreapp.util.CallBack;
import com.example.bookstoreapp.util.ViewState;


import java.util.ArrayList;

public class BooksViewModel extends ViewModel {
    MutableLiveData<ViewState<ArrayList<BookModel>>> notesMutableLiveData = new MutableLiveData<>();
    private static final String TAG = "NotesViewModel";
    private final FirebaseBookManager firebaseBookManager;

    public BooksViewModel() {
        firebaseBookManager = new FirebaseBookManager();
        loadNotes();
    }

    private void loadNotes() {
        notesMutableLiveData.setValue(new ViewState.Loading<>());
        firebaseBookManager.getAllBooks(new CallBack<ArrayList<BookModel>>() {
            @Override
            public void onSuccess(ArrayList<BookModel> data) {
                Log.e(TAG, "onNoteReceived: " + data);
                notesMutableLiveData.setValue(new ViewState.Success<>(data));
            }

            @Override
            public void onFailure(Exception exception) {
                notesMutableLiveData.setValue(new ViewState.Failure<>(exception));
            }
        });
    }
}
