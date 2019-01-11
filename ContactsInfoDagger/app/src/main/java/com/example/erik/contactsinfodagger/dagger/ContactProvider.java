package com.example.erik.contactsinfodagger.dagger;

import android.content.Context;

import com.example.erik.contactsinfodagger.view.main.MainFragment;
import com.example.erik.contactsinfodagger.view.main.MainPresenter;

import dagger.Module;
import dagger.Provides;


@Module
public class ContactProvider {
    @ContactScope
    private final Context context;

    public ContactProvider(Context context){
        this.context = context;
    }

    @ContactScope
    @Provides
    MainFragment getMainFragment(){
        return new MainFragment();
    }

    @ContactScope
    @Provides
    MainPresenter getMainPresenter(MainFragment mainFragment, Context context){
        return new MainPresenter(mainFragment, this.context);
}

    @ContactScope
    @Provides
    Context getContext(){
        return this.context;
    }

}
