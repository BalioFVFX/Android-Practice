package com.example.erik.activities_adapters_events_ui_02;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.erik.activities_adapters_events_ui_02.entity.Person;

import java.util.List;



public class MySuperAdapter extends ArrayAdapter<Person> {
    private Context context;
    private List<Person> persons;

    public MySuperAdapter(@NonNull Context context,List<Person> persons) {
        super(context,R.layout.activity_detail, persons);
        this.context = context;
        this.persons = persons;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.activity_detail, null, false);
        TextView tv_details = v.findViewById(R.id.tv_detail);
        tv_details.setText(String.format("%s %s", persons.get(position).getFirstName(), persons.get(position).getLastName()));
        return v;
    }
}
