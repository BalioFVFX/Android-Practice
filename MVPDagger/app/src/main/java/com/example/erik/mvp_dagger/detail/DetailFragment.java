package com.example.erik.mvp_dagger.detail;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.erik.mvp_dagger.R;

public class DetailFragment extends Fragment implements IDetail.View{


    private IDetail.Presenter presenter;
    private TextView textView;

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        this.textView = (TextView)view.findViewById(R.id.tv_name);
        this.presenter.start();
        return view;
    }

    @Override
    public void setPresenter(IDetail.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setName(String name) {
        this.textView.setText(name);
    }
}
