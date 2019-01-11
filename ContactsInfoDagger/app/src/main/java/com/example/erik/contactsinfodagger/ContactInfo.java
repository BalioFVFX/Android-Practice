package com.example.erik.contactsinfodagger;

import java.io.Serializable;

public class ContactInfo implements Serializable {
    private String name;
    private String phoneNumber;

    public ContactInfo(String name, String phoneNumber) {
        this.setName(name);
        this.setPhoneNumber(phoneNumber);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
