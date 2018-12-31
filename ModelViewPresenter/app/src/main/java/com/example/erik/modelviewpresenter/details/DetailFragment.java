package com.example.erik.modelviewpresenter.details;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.erik.modelviewpresenter.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment implements Detail.View {


    private Detail.Presenter presenter;
    private TextView textView;

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_detail, container, false);

        this.textView = (TextView)root.findViewById(R.id.tv_name);
        this.presenter.start();
        return root;
    }

    @Override
    public void setPresenter(Detail.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void updateText(String text) {
        this.textView.setText("You clicked on " + text);
    }
}
