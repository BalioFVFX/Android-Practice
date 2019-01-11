package com.example.erik.contactsinfodagger.view.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.erik.contactsinfodagger.ContactInfo;
import com.example.erik.contactsinfodagger.R;

import java.util.List;

public class ContactAdapter extends ArrayAdapter<ContactInfo> {

    private Context context;
    private List<ContactInfo> contacts;

    public ContactAdapter(Context context, List<ContactInfo> contactInfo){
        super(context, 0, contactInfo);
        this.context = context;
        this.contacts = contactInfo;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listView = convertView;
        if(listView == null){
            listView = LayoutInflater.from(context).inflate(R.layout.list_item, null, false);
        }
        ContactInfo contactInfo = this.getItem(position);
        TextView contactNameTextView = listView.findViewById(R.id.tv_contact_name);
        contactNameTextView.setText(contactInfo.getName());

        return listView;

    }

    @Override
    public ContactInfo getItem(int position) {
        return this.contacts.get(position);
    }




}
