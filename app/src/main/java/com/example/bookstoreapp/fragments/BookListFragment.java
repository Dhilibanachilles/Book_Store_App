package com.example.bookstoreapp.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.bookstoreapp.R;
import com.example.bookstoreapp.adapters.BookListAdapter;
import com.example.bookstoreapp.adapters.OnBookListener;
import com.example.bookstoreapp.data_manager.FirebaseBookManager;
import com.example.bookstoreapp.data_manager.model.BookModel;
import com.example.bookstoreapp.data_manager.model.BooksViewModel;
import com.example.bookstoreapp.ui.dashboard.HomeActivity;
import com.example.bookstoreapp.util.CallBack;

import java.util.ArrayList;

public class BookListFragment extends Fragment {
    BooksViewModel booksViewModel;
    RecyclerView recyclerView;
    FirebaseBookManager firebaseBookManager;
    RecyclerView.LayoutManager layoutManager;
    BookListAdapter adapter;
    private static final String TAG = "BookListFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_booklist, container, false);

        recyclerView = view.findViewById(R.id.bookList_RecyclerView);
        layoutManager = new StaggeredGridLayoutManager(1,
                StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        firebaseBookManager = new FirebaseBookManager();
        booksViewModel = new ViewModelProvider(this).get(BooksViewModel.class);
        firebaseBookManager.getAllBooks(new CallBack<ArrayList<BookModel>>() {
            @Override
            public void onSuccess(ArrayList<BookModel> data) {
                adapter = new BookListAdapter(data, (position, viewHolder) ->
                        Toast.makeText(getContext(), "onBookClick", Toast.LENGTH_SHORT).show());
                Log.e(TAG, "onSuccess: " + data );
            }

            @Override
            public void onFailure(Exception exception) {
            }
        });
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        return view;
    }
}
