package com.example.erik.contactsinfodagger.view.detail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.erik.contactsinfodagger.ContactInfo;
import com.example.erik.contactsinfodagger.R;
import com.example.erik.contactsinfodagger.view.detail.dagger.DaggerDetailComponent;
import com.example.erik.contactsinfodagger.view.detail.dagger.DetailComponent;
import com.example.erik.contactsinfodagger.view.detail.dagger.DetailModule;

import javax.inject.Inject;

public class DetailActivity extends AppCompatActivity {

    @Inject
    DetailFragment detailFragment;

    @Inject
    DetailPresenter detailPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ContactInfo contactInfo = (ContactInfo)getIntent().getSerializableExtra("contact");

        DetailComponent detailComponent = DaggerDetailComponent.builder().detailModule(new DetailModule(contactInfo)).build();
        detailComponent.inject(this);

        detailFragment.setPresenter(detailPresenter);
        this.getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, detailFragment).commit();

    }
}
