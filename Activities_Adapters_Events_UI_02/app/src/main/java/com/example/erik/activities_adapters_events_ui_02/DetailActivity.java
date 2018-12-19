package com.example.erik.activities_adapters_events_ui_02;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_detail);
        ListView listView = (ListView)this.findViewById(R.id.lv_id);
        MySuperAdapter mySuperAdapter = new MySuperAdapter(this, MainActivity.persons);
        listView.setAdapter(mySuperAdapter);
    }
}
