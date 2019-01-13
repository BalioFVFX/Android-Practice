package com.example.erik.datalayer_rx;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.data.model.User;

import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {
    private Context  context;
    private List<User> users;
    public UserAdapter(Context context, List<User> users) {
        super(context, 0, users);
        this.context = context;
        this.users = users;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        TextView tvName = (TextView)view.findViewById(R.id.tv_name);
        TextView tvUsername = (TextView)view.findViewById(R.id.tv_username);
        TextView tvEmail = (TextView)view.findViewById(R.id.tv_email);

        tvName.setText("Name: " + users.get(position).getName());
        tvUsername.setText("Username: " + users.get(position).getUsername());
        tvEmail.setText("Email: " + users.get(position).getEmail());


        return view;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return users.size();
    }
}
