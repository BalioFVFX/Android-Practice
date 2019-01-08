package com.example.erik.contentresolvercontactsdagger;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.annotation.RequiresApi;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ContactResolver {
    private final Context context;

    @Inject
    public ContactResolver(Context context){
        this.context = context;
    }

    Observable<List<ContactData>> getContacts(){

        return Observable.create(new ObservableOnSubscribe<List<ContactData>>() {
            @Override
            public void subscribe(ObservableEmitter<List<ContactData>> emitter) throws Exception {
                String contactSelection = ContactsContract.Contacts.IN_VISIBLE_GROUP + " = '1'";
                    Cursor cursor = context.getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, contactSelection, null, null);


                List<ContactData> contacts = new ArrayList<>();
                while(cursor.moveToNext()){
                    String displayName = cursor.getString(cursor.getColumnIndex(ContactsContract.PhoneLookup.DISPLAY_NAME));
                    ContactData contactData = new ContactData(displayName);
                    contacts.add(contactData);
                }
                cursor.close();
                emitter.onNext(contacts);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());

    }
}
