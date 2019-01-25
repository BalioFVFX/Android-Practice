package com.example.erik.mvpdagger2.daggermain;

import com.example.erik.mvpdagger2.MainActivity;
import com.example.erik.mvpdagger2.MainFragment;
import com.example.erik.mvpdagger2.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModules {

    @MainScope
    @Provides
    MainFragment getMainFragment(){
        return new MainFragment();
    }

    @MainScope
    @Provides
    MainPresenter getMainPresenter(MainFragment mainFragment){
        MainPresenter mainPresenter = new MainPresenter(mainFragment);
        mainPresenter.getView().setPresenter(mainPresenter);
        return mainPresenter;
    }
}
