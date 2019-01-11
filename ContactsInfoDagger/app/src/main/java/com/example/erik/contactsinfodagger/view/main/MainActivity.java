package com.example.erik.contactsinfodagger.view.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.erik.contactsinfodagger.R;
import com.example.erik.contactsinfodagger.dagger.ContactProvider;
import com.example.erik.contactsinfodagger.dagger.DaggerMainComponent;
import com.example.erik.contactsinfodagger.dagger.MainComponent;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    public MainFragment mainFragment;

    @Inject
    public MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainComponent daggerMainComponent = DaggerMainComponent.builder().contactProvider(new ContactProvider(getApplicationContext())).build();
        daggerMainComponent.inject(this);
        mainFragment.setPresenter(mainPresenter);

        this.getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, mainFragment).commit();
    }
}
