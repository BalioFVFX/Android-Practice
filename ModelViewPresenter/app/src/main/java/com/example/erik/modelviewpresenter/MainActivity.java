package com.example.erik.modelviewpresenter;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.erik.modelviewpresenter.main.Main;
import com.example.erik.modelviewpresenter.main.MainFragment;
import com.example.erik.modelviewpresenter.main.MainPresenter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainFragment mainFragment = new MainFragment();
        Main.Presenter mainPresenter = new MainPresenter(mainFragment);

        this.getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, (Fragment)mainPresenter.getView()).commit();
    }
}
