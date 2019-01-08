package com.example.erik.contentresolvercontactsdagger.dagger;

import com.example.erik.contentresolvercontactsdagger.MainActivity;

import dagger.Component;

@ContactScope
@Component(modules = ContactModule.class)
public interface ContactDaggerComponent {
    void inject(MainActivity mainActivity);
}
