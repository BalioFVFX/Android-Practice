package com.example.erik.callbacks;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
implements UiChanger{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirstFragment firstFragment = new FirstFragment();
        firstFragment.setEvenetListener(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, firstFragment).commit();
    }

    @Override
    public void ChangeUI(int red, int green, int blue) {
        getWindow().getDecorView().setBackgroundColor(Color.rgb(red, green, blue));
    }

}
