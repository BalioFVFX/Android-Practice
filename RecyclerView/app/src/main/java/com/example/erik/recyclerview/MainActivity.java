package com.example.erik.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.erik.recyclerview.models.Computer;
import com.example.erik.recyclerview.recycler.MyRecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
implements MyRecyclerView.ICheckBoxListener {

    private RecyclerView recyclerView;
    private ArrayList<Computer> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.recyclerView = findViewById(R.id.rec_view);
        this.recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        this.recyclerView.setClipToPadding(true);
        this.data = new ArrayList<Computer>();

        data.add(new Computer("PC 1", "Core i3", "4GB DDR3", 650d));
        data.add(new Computer("PC 2", "Core i5", "8GB DDR3", 1050d));
        data.add(new Computer("PC 3", "Core i7", "16GB DDR3", 2050d));
        data.add(new Computer("PC 4", "Core i9", "32GB DDR3", 3050d));
        this.recyclerView.setAdapter(new MyRecyclerView(this, data, this));

    }

    @Override
    public void onCheckBoxClickListener(TextView name, int position) {
        Toast.makeText(this, position + " pos", Toast.LENGTH_SHORT).show();
        name.setText("Checked");
    }
}
