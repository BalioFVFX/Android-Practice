package com.example.erik.modelviewpresenter.main;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.erik.modelviewpresenter.R;
import com.example.erik.modelviewpresenter.details.DetailActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment
implements Main.View, AdapterView.OnItemClickListener {


    private Main.Presenter presenter;
    private ListView listView;
    private ArrayAdapter<String> adapter;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        this.listView = (ListView)root.findViewById(R.id.list_view);
        this.listView.setOnItemClickListener(this);
        this.adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1);
        this.listView.setAdapter(adapter);
        this.presenter.start();
        return root;
    }

    @Override
    public void setPresenter(Main.Presenter presenter) {
        this.presenter = presenter;

    }

    @Override
    public void showData(String data) {
        Toast.makeText(getContext(), data, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setData(String[] data) {
        this.adapter.clear();
        this.adapter.addAll(data);
    }

    @Override
    public void navigate(String name) {
        Intent intent = new Intent(getContext(), DetailActivity.class);
        intent.putExtra("details", name);
        startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        this.presenter.getClickedItem(position);
    }


}
