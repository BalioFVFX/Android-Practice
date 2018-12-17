package com.example.erik.activities_adapters_events_ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.erik.activities_adapters_events_ui.entity.Person;


public class MySuperCustomAdapter extends ArrayAdapter<Person> {

    private Context context;
    private Person[] humans;

    public MySuperCustomAdapter(Context context, Person[] humans) {
        super(context, R.layout.activity_detail, humans);
        this.context = context;
        this.humans = humans;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.activity_detail, null, false);
        TextView details_tv = (TextView)rowView.findViewById(R.id.tv_details);
        details_tv.setText(humans[position].getName());
        return rowView;
    }


}
