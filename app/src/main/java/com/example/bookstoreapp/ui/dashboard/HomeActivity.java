package com.example.bookstoreapp.ui.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.bookstoreapp.R;
import com.example.bookstoreapp.SharedPreferenceHelper;
import com.example.bookstoreapp.fragments.BookListFragment;
import com.example.bookstoreapp.fragments.CartFragment;
import com.example.bookstoreapp.fragments.OrderFragment;
import com.example.bookstoreapp.fragments.ProfileFragment;
import com.example.bookstoreapp.fragments.WishListFragment;
import com.example.bookstoreapp.ui.authentication.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {
    SharedPreferenceHelper sharedPreferenceHelper;
    BookListFragment bookListFragment;
    CartFragment cartFragment;
    ProfileFragment profileFragment;
    WishListFragment wishListFragment;
    OrderFragment orderFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        sharedPreferenceHelper = new SharedPreferenceHelper(this);
        bookListFragment = new BookListFragment();
        cartFragment = new CartFragment();
        orderFragment = new OrderFragment();
        profileFragment = new ProfileFragment();
        wishListFragment = new WishListFragment();


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    bookListFragment).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.dashboard_menu, menu);

        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.cart: {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        cartFragment).addToBackStack(null).commit();
                return true;
            } case R.id.logout: {
                logout();
                return true;
            } case R.id.favourites: {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        wishListFragment).addToBackStack(null).commit();
                return true;
            } case R.id.orders: {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        orderFragment).addToBackStack(null).commit();
                return true;
            } case R.id.profile: {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        profileFragment).addToBackStack(null).commit();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        sharedPreferenceHelper.setLoggedIn(false);
        finish();
        Intent intToMain = new Intent(HomeActivity.this, LoginActivity.class);
        Toast.makeText(HomeActivity.this, "Logged Out", Toast.LENGTH_SHORT).show();
        startActivity(intToMain);
        finish();
    }
}