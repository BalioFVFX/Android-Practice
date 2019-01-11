package com.example.erik.contactsinfodagger.view.detail.dagger;

import com.example.erik.contactsinfodagger.ContactInfo;
import com.example.erik.contactsinfodagger.view.detail.DetailFragment;
import com.example.erik.contactsinfodagger.view.detail.DetailPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class DetailModule {

    private final ContactInfo contactInfo;

    public DetailModule(ContactInfo contactInfo){
        this.contactInfo = contactInfo;
    }

    @DetailScope
    @Provides
    public DetailFragment getDetailFragment(){
        return new DetailFragment();
    }

    @DetailScope
    @Provides
    public DetailPresenter getDetailPresenter(DetailFragment detailFragment, ContactInfo contactInfo){
        return new DetailPresenter(detailFragment, contactInfo);
    }

    @DetailScope
    @Provides
    public ContactInfo getContactName(){
        return this.contactInfo;
    }

}
