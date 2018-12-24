package com.example.erik.async_navigation_gestures;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.UpdateAppearance;

import com.example.erik.async_navigation_gestures.fragments.HomeFragment;
import com.example.erik.async_navigation_gestures.fragments.SearchFragment;
import com.example.erik.async_navigation_gestures.topnavigation.TopNavigationAdapter;

public class MainActivity extends AppCompatActivity {

    private static  ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.viewPager = (ViewPager)findViewById(R.id.view_pager);
        HomeFragment homeFragment = new HomeFragment();
        SearchFragment searchFragment = SearchFragment.newInstance(homeFragment);
        viewPager.setAdapter(new TopNavigationAdapter(getSupportFragmentManager(), new Fragment[]{homeFragment, searchFragment}));
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

    }

}
