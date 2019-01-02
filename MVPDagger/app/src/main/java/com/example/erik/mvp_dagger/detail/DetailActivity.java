package com.example.erik.mvp_dagger.detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.erik.mvp_dagger.detail.dagger.DaggerDetailComponent;
import com.example.erik.mvp_dagger.detail.dagger.DetailComponent;
import com.example.erik.mvp_dagger.R;

import javax.inject.Inject;

public class DetailActivity extends AppCompatActivity {

    @Inject
    DetailFragment detailFragment;

    @Inject
    DetailPresenter detailPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        final String name = getIntent().getStringExtra("name_data");

        DetailComponent component = DaggerDetailComponent.builder().build();
        component.injectActivity(this);

        detailFragment.setPresenter(detailPresenter);
        detailPresenter.setName(name);

        this.getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_layout, detailFragment).commit();
    }

}
