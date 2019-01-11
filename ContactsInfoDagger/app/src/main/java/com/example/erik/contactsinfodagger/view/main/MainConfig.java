package com.example.erik.contactsinfodagger.view.main;

import com.example.erik.contactsinfodagger.ContactInfo;

import java.util.List;

public interface MainConfig {
    interface MainView {
        void setPresenter(MainPresenter mainPresenter);
        void showContacts(List<ContactInfo> contacts);
    }

    interface MainPresenter{
        void start();
        void getContacts();
    }
}
