package com.example.erik.dagger.dagger.module;

import android.content.Context;

import com.example.erik.dagger.dagger.scope.MyApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    private final Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @MyApplicationScope
    public Context getContext() {
        return this.context;
    }
}
