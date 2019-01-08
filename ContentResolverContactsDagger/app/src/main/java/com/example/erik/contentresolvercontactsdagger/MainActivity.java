package com.example.erik.contentresolvercontactsdagger;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter arrayAdapter;
    private CompositeDisposable compositeDisposable;

    @Inject
    ContactResolver contactResolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ContactResolver contactResolver = new ContactResolver(this);
        this.listView = findViewById(R.id.lv_contacts);
        this.arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1);
        this.listView.setAdapter(arrayAdapter);
        this.compositeDisposable = new CompositeDisposable();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if(checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED){
                requestPermissions(new String[] {Manifest.permission.READ_CONTACTS}, 0);
            }
        }
        compositeDisposable.add(contactResolver.getContacts().subscribe(new Consumer<List<ContactData>>() {
            @Override
            public void accept(List<ContactData> contactData) throws Exception {
                arrayAdapter.clear();
                arrayAdapter.addAll(contactData);
            }
        }));
    }
}
