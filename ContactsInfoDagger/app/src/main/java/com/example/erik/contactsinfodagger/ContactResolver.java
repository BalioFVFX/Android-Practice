package com.example.erik.contactsinfodagger;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;

import android.net.Uri;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;

public class ContactResolver {
    private final Context context;

    public ContactResolver(Context context){
        this.context = context;
    }

    public ArrayList<ContactInfo> getContacts(){

        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        String selection = ContactsContract.Contacts.HAS_PHONE_NUMBER;
        Cursor cursor = context.getContentResolver().query(uri, new String[]{ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME_PRIMARY}, selection, null, null);
        ArrayList<ContactInfo> contacts = new ArrayList<>();


        while (cursor.moveToNext()) {

            String contactNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            String contactName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME_PRIMARY));
            contacts.add(new ContactInfo(contactName, contactNumber));
            cursor.moveToNext();
        }

        cursor.close();
        cursor = null;
        return contacts;
    }

}
