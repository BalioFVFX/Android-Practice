package com.example.erik.mvp_dagger.main;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.erik.mvp_dagger.R;
import com.example.erik.mvp_dagger.detail.DetailActivity;

import java.util.List;


public class MainFragment extends Fragment implements IMain.View, AdapterView.OnItemClickListener {

    private ListView listView;
    private IMain.Presenter presenter;
    private ArrayAdapter<String> stringArrayAdapter;
    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_main, container, false);
        this.listView = view.findViewById(R.id.list_view);
        this.stringArrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1);
        listView.setAdapter(stringArrayAdapter);
        listView.setOnItemClickListener(this);
        this.presenter.start();
        return view;
    }

    @Override
    public void updateUI(List<String> names) {
        this.stringArrayAdapter.clear();
        this.stringArrayAdapter.addAll(names);
    }

    @Override
    public void setPresenter(IMain.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void changeView(String dataToTransfer) {
        Intent intent = new Intent(getContext(), DetailActivity.class);
        intent.putExtra("name_data", dataToTransfer);
        startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        this.presenter.changeView(position);
    }
}
