package com.example.erik.modelviewpresenter.details;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.erik.modelviewpresenter.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        DetailFragment detailFragment = new DetailFragment();
        Detail.Presenter detailPresenter = new DetailPresenter(detailFragment);

        String name = getIntent().getStringExtra("details");

        detailPresenter.setName(name);

        this.getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_content, (Fragment)detailPresenter.getView()).commit();
    }
}
