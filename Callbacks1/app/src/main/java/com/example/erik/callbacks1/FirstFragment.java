package com.example.erik.callbacks1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    private Button button;
    private ICustomToast iCustomToast;

    public FirstFragment() {
        // Required empty public constructor
    }


    public void setEventListener(ICustomToast iCustomToast){
        this.iCustomToast = iCustomToast;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        this.button = (Button)view.findViewById(R.id.btn_do_a_toast);
        this.button.setOnClickListener(new CustomOnClickListener(){
            @Override
            public void onClick(View v) {
                iCustomToast.showToastWithText("Message from the fragment!");
            }
        });
        return view;
    }


}
