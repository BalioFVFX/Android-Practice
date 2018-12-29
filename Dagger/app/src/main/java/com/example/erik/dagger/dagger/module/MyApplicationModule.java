package com.example.erik.dagger.dagger.module;

import com.example.erik.dagger.dagger.scope.MyApplicationScope;
import com.google.gson.Gson;

import dagger.Module;

@Module
public class MyApplicationModule {

    @MyApplicationScope
    public Gson getGson(){
        return new Gson();
    }
}
