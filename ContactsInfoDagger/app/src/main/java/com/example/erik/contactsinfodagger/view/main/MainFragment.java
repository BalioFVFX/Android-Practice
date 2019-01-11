package com.example.erik.contactsinfodagger.view.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.erik.contactsinfodagger.ContactInfo;
import com.example.erik.contactsinfodagger.R;
import com.example.erik.contactsinfodagger.view.detail.DetailActivity;

import java.util.ArrayList;
import java.util.List;


public class MainFragment extends Fragment
        implements MainConfig.MainView,
        AdapterView.OnItemClickListener {

    private MainConfig.MainPresenter mainPresenter;
    private ListView listView;
    private ContactAdapter listAdapter;

    public MainFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_main, container, false);
        this.listView = (ListView)view.findViewById(R.id.lv_contacts);

        if(getContext() != null){
            this.listAdapter = new ContactAdapter(getContext(), new ArrayList<ContactInfo>());
            this.listView.setAdapter(listAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(getContext(), DetailActivity.class);
                    intent.putExtra("contact", listAdapter.getItem(position));
                    startActivity(intent);
                }
            });
        }

        this.mainPresenter.start();
        return view;
    }

    @Override
    public void setPresenter(MainConfig.MainPresenter mainPresenter) {
        this.mainPresenter = mainPresenter;
    }

    @Override
    public void showContacts(List<ContactInfo> contacts) {
        this.listAdapter.clear();
        this.listAdapter.addAll(contacts);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
