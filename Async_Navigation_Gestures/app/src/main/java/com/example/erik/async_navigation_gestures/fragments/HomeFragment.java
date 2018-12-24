package com.example.erik.async_navigation_gestures.fragments;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.erik.async_navigation_gestures.IWeather;
import com.example.erik.async_navigation_gestures.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment
implements IName, IWeather {


    private TextView degreesTextView;
    private IWeather iWeather;
    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(IWeather iWeather){
        HomeFragment homeFragment = new HomeFragment();
        homeFragment.iWeather = iWeather;

        return homeFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        this.degreesTextView = view.findViewById(R.id.tv_degrees);
        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                v.setBackgroundColor(Color.rgb(209, 94, 205));
                return true;
            }
        });
        return view;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public String getFragmentName() {
        return "Weather";
    }


    @Override
    public void updateWeatherTextView(String tempStr) {
        this.degreesTextView.setText(tempStr + "º");
    }
}
