package com.example.erik.contactsinfodagger.view.detail.dagger;

import com.example.erik.contactsinfodagger.dagger.ContactScope;
import com.example.erik.contactsinfodagger.view.detail.DetailActivity;

import dagger.Component;

@DetailScope
@Component(modules = {DetailModule.class})
public interface DetailComponent {
    void inject(DetailActivity detailActivity);
}
