package com.example.erik.mvpdagger2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.network.models.Activity;


public class MainFragment extends Fragment
        implements IMain.View, View.OnClickListener {


    private IMain.Presenter presenter;
    private RatingBar accessibilityRatingBar;
    private TextView activityTextView;
    private TextView priceTextView;
    private TextView typeTextView;
    private Button activityButton;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        this.accessibilityRatingBar = view.findViewById(R.id.ratingBar_accessibility);
        this.activityTextView = view.findViewById(R.id.tv_activity);
        this.priceTextView = view.findViewById(R.id.tv_price);
        this.typeTextView = view.findViewById(R.id.tv_type);
        this.activityButton = view.findViewById(R.id.btn_activity);
        this.activityButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void setPresenter(IMain.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void updateViews(Activity activity) {
        this.accessibilityRatingBar.setRating(activity.getAccessibility() * 10);
        this.activityTextView.setText(activity.getActivity());
        this.priceTextView.setText(String.format("Price: %s", activity.getPrice()));
        this.typeTextView.setText(String.format("Type: %s", activity.getType()));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_activity:
                this.presenter.getRandomActivity();
                break;
            default:
                break;
        }
    }
}
