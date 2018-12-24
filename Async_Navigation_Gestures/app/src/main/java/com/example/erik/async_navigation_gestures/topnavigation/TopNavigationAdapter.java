package com.example.erik.async_navigation_gestures.topnavigation;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.widget.Toast;

import com.example.erik.async_navigation_gestures.fragments.HomeFragment;
import com.example.erik.async_navigation_gestures.fragments.IName;
import com.example.erik.async_navigation_gestures.fragments.SearchFragment;

import java.util.Random;

public class TopNavigationAdapter extends FragmentStatePagerAdapter {

    private final Fragment[] fragments;

    public TopNavigationAdapter(FragmentManager fm, Fragment[] fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int i) {
        return fragments[i];
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return ((IName)fragments[position]).getFragmentName();
    }


}

