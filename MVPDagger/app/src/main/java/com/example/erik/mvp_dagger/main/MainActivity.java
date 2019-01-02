package com.example.erik.mvp_dagger.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.erik.mvp_dagger.R;
import com.example.erik.mvp_dagger.data.Data;

import com.example.erik.mvp_dagger.main.dagger.DaggerMainComponent;
import com.example.erik.mvp_dagger.main.dagger.MainComponent;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity {

    @Inject
    MainFragment mainFragment;

    @Inject
    MainPresenter mainPresenter;

    @Inject
    Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MainComponent component = DaggerMainComponent.builder().build();
        component.injectActivity(this);

        mainFragment.setPresenter(mainPresenter);
        mainPresenter.setNames(data.getAll());

        this.getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_layout, mainFragment).commit();
    }
}
