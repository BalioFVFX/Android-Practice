package com.example.erik.locationmanager.dagger;

import com.example.erik.locationmanager.MainActivity;

import dagger.Component;
@LocationScope
@Component(modules = {LocationModule.class})
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
