package com.example.erik.contactsinfodagger.view.detail;

import com.example.erik.contactsinfodagger.ContactInfo;

public class DetailConfig {
    interface DetailView{
        void setPresenter(com.example.erik.contactsinfodagger.view.detail.DetailPresenter detailPresenter);
        void updateTextViews(ContactInfo contactInfo);
    }

    interface DetailPresenter{
        void start();
    }
}
