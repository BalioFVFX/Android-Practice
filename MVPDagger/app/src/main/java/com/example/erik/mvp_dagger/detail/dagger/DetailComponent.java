package com.example.erik.mvp_dagger.detail.dagger;

import com.example.erik.mvp_dagger.detail.DetailActivity;


import dagger.Component;

@DetailScope
@Component(modules = DetailModule.class)
public interface DetailComponent {

    void injectActivity(DetailActivity detailActivity);

}
