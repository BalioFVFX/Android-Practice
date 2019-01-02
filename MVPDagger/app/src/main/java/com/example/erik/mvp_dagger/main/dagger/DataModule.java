package com.example.erik.mvp_dagger.main.dagger;

import com.example.erik.mvp_dagger.data.Data;



import dagger.Module;
import dagger.Provides;

@MVPDaggerScope
@Module
public class DataModule {
    @Provides
    Data getData(){
        return new Data();
    }
}
