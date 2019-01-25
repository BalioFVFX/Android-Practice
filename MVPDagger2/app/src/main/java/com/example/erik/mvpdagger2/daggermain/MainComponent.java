package com.example.erik.mvpdagger2.daggermain;

import com.example.erik.mvpdagger2.MainActivity;

import dagger.Component;

@MainScope
@Component(modules = {MainModules.class})
public interface MainComponent {
    void injectActivity(MainActivity mainActivity);
}
