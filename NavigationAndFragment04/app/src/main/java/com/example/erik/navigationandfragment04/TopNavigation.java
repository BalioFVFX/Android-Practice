package com.example.erik.navigationandfragment04;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class TopNavigation extends Fragment {


    public TopNavigation() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_top_navigation, container, false);

        ViewPager viewPager = view.findViewById(R.id.vPager);
        viewPager.setAdapter(new MySuperFragmentStateAdapter(getChildFragmentManager(), new Fragment[]{new FirstFragment(), new SecondFragment()}));

        TabLayout tableLayout = (TabLayout) view.findViewById(R.id.table);
        tableLayout.setupWithViewPager(viewPager);
        tableLayout.setEnabled(true);

        return view;
    }

}
