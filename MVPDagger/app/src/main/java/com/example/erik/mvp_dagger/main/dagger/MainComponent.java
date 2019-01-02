package com.example.erik.mvp_dagger.main.dagger;

import com.example.erik.mvp_dagger.data.Data;
import com.example.erik.mvp_dagger.detail.DetailFragment;
import com.example.erik.mvp_dagger.detail.DetailPresenter;
import com.example.erik.mvp_dagger.main.MainActivity;
import com.example.erik.mvp_dagger.main.MainFragment;
import com.example.erik.mvp_dagger.main.MainPresenter;

import dagger.Component;
@MVPDaggerScope
@Component(modules = {
        MainModule.class,
        DataModule.class
})
public interface MainComponent {

    void injectActivity(MainActivity mainActivity);

}
