package com.example.bookstoreapp.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookstoreapp.R;
import com.example.bookstoreapp.SharedPreferenceHelper;
import com.example.bookstoreapp.data_manager.model.BookModel;

import java.util.ArrayList;

public class BookListAdapter extends RecyclerView.Adapter<MyViewHolder> {

    SharedPreferenceHelper sharedPreferenceHelper;
    private static final String TAG = "BookListAdapter";
    private ArrayList<BookModel> booksList = new ArrayList<BookModel>();
    private Context context;
    private final OnBookListener onBookListener;

    public BookListAdapter(ArrayList<BookModel> booksList,OnBookListener onBookListener) {
        this.booksList = booksList;
        this.onBookListener=onBookListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.booklist,parent,false);
        return new MyViewHolder(view,onBookListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        BookModel book = booksList.get(position);
        Log.e(TAG, "onBindViewHolder: " + book.getBookTitle() + " " + position );
        holder.bind(book);
    }

    @Override
    public int getItemCount() {
        return booksList.size();
    }

    public BookModel getItem(int position) {
        try{
            return booksList.get(position);
        } catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return null;
    }
}