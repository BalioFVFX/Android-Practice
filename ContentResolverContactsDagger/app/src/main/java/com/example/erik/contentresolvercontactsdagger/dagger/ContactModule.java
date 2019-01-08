package com.example.erik.contentresolvercontactsdagger.dagger;

import android.content.Context;

import dagger.Module;
import dagger.Provides;


@Module
public class ContactModule {
    private final Context context;

    @Provides
    @ContactScope
    Context getContext(){
        return this.context;
    }


    public ContactModule(Context context){
        this.context = context;
    }
}
