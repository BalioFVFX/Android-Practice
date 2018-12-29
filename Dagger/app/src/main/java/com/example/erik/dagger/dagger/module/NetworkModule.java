package com.example.erik.dagger.dagger.module;

import com.example.erik.dagger.dagger.scope.MyApplicationScope;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
public class NetworkModule {

    @Provides
    @MyApplicationScope
    OkHttpClient getOkHttpClient(){
        return new OkHttpClient();
    }

}
