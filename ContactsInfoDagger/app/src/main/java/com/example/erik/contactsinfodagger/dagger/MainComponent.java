package com.example.erik.contactsinfodagger.dagger;

import com.example.erik.contactsinfodagger.view.main.MainActivity;

import dagger.Component;

@ContactScope
@Component(modules = {ContactProvider.class})
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
