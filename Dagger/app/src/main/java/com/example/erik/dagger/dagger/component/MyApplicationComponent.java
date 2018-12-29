package com.example.erik.dagger.dagger.component;

import com.example.erik.dagger.dagger.module.ContextModule;
import com.example.erik.dagger.dagger.module.NetworkModule;
import com.example.erik.dagger.dagger.scope.MyApplicationScope;

import dagger.Component;
import okhttp3.OkHttpClient;

@Component(modules = {NetworkModule.class, ContextModule.class})
@MyApplicationScope
public interface MyApplicationComponent {

    OkHttpClient getOkHttpClient();
}
