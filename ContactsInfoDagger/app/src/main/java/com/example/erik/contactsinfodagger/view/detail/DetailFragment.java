package com.example.erik.contactsinfodagger.view.detail;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.erik.contactsinfodagger.ContactInfo;
import com.example.erik.contactsinfodagger.R;
import com.example.erik.contactsinfodagger.view.detail.DetailConfig.DetailView;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment
implements DetailView {


    private DetailPresenter detailPresenter;
    private TextView contactNameTextView;
    private TextView contactPhoneNumberTextView;

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        this.contactNameTextView = view.findViewById(R.id.tv_contact_name);
        this.contactPhoneNumberTextView = view.findViewById(R.id.tv_contact_phone_number);
        this.detailPresenter.start();
        return view;
    }

    @Override
    public void setPresenter(DetailPresenter detailPresenter) {
        this.detailPresenter = detailPresenter;
    }

    @Override
    public void updateTextViews(ContactInfo contactInfo) {
        this.contactNameTextView.setText(contactInfo.getName());
        this.contactPhoneNumberTextView.setText(contactInfo.getPhoneNumber());
    }
}
