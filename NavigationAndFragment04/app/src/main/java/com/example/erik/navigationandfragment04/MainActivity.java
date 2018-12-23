package com.example.erik.navigationandfragment04;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getSupportFragmentManager().beginTransaction().replace(R.id.top_nav_fragment, new TopNavigation()).commit();
    }
}
