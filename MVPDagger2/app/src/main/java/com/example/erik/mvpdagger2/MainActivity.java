package com.example.erik.mvpdagger2;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.erik.mvpdagger2.daggermain.DaggerMainComponent;
import com.example.erik.mvpdagger2.daggermain.MainComponent;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    MainFragment mainFragment;

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainComponent mainComponent = DaggerMainComponent.builder().build();
        mainComponent.injectActivity(this);

        this.getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, (Fragment)mainPresenter.getView()).commit();
    }
}
