package com.example.erik.contactsinfodagger.view.detail;

import com.example.erik.contactsinfodagger.ContactInfo;


public class DetailPresenter implements DetailConfig.DetailPresenter {

    private final ContactInfo contactInfo;

    private final DetailFragment detailFragment;

    public DetailPresenter(DetailFragment detailFragment, ContactInfo contactInfo){
        this.detailFragment = detailFragment;
        this.contactInfo = contactInfo;
    }

    @Override
    public void start() {
        detailFragment.updateTextViews(contactInfo);
    }
}
