package com.example.erik.mvp_dagger.detail.dagger;

import com.example.erik.mvp_dagger.detail.DetailFragment;
import com.example.erik.mvp_dagger.detail.DetailPresenter;


import dagger.Module;
import dagger.Provides;

@Module
public class DetailModule {

    @DetailScope
    @Provides
    DetailFragment getDetailFragment(){
        return new DetailFragment();
    }

    @DetailScope
    @Provides
    DetailPresenter getDetailPresenter(DetailFragment detailFragment){
        return new DetailPresenter(detailFragment);
    }
}
