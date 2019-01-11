package com.example.erik.contactsinfodagger.view.main;

import android.content.Context;

import com.example.erik.contactsinfodagger.ContactResolver;

public class MainPresenter implements MainConfig.MainPresenter {
    private final ContactResolver contactResolver;
    private final MainFragment mainFragment;


    public MainPresenter(MainFragment mainFragment, Context context){
        this.mainFragment = mainFragment;
        this.contactResolver = new ContactResolver(context);

    }

    @Override
    public void start() {
        this.getContacts();
    }

    @Override
    public void getContacts() {
        mainFragment.showContacts(contactResolver.getContacts());
    }
}
