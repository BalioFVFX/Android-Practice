package com.example.erik.mvp_dagger.main.dagger;


import com.example.erik.mvp_dagger.main.MainFragment;
import com.example.erik.mvp_dagger.main.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    @Provides
    @MVPDaggerScope
    MainFragment getMainView(){
        return new MainFragment();
    }


    @Provides
    @MVPDaggerScope
    MainPresenter getMainPresenter(MainFragment mainFragment){
        return new MainPresenter(mainFragment);
    }
}
