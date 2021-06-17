package com.example.bookstoreapp.adapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookstoreapp.R;
import com.example.bookstoreapp.SharedPreferenceHelper;
import com.example.bookstoreapp.data_manager.model.BookModel;

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView bookTitle,bookAuthor;
    OnBookListener onBookListener;
    SharedPreferenceHelper sharedPreferenceHelper;

    public MyViewHolder(@NonNull View itemView, OnBookListener onBookListener) {
        super(itemView);
        bookTitle = itemView.findViewById(R.id.bookTitle);
        bookAuthor = itemView.findViewById(R.id.bookAuthor);

        sharedPreferenceHelper = new SharedPreferenceHelper(itemView.getContext());
        this.onBookListener = onBookListener;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        onBookListener.onBookClick(getAdapterPosition(), v);
    }

    public void bind(BookModel book) {
        bookTitle.setText(book.getBookTitle());
        bookAuthor.setText(book.getBookAuthor());
    }
}