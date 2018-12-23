package com.example.erik.navigationandfragment04;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class MySuperFragmentStateAdapter extends FragmentStatePagerAdapter {

    private Fragment[] fragments;

    public MySuperFragmentStateAdapter(FragmentManager fm, Fragment[] fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int i) {
        return this.fragments[i];
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return ((IName)this.fragments[position]).getFragmentName();
    }

    @Override
    public int getCount() {
        return this.fragments.length;
    }
}
