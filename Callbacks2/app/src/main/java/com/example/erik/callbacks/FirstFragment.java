package com.example.erik.callbacks;



import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    private Button button;
    private Random rnd;
    private UiChanger uiChanger;

    public FirstFragment() {
        // Required empty public constructor
    }


    public void setEvenetListener(UiChanger uiChanger){
        this.uiChanger = uiChanger;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        this.button = view.findViewById(R.id.btn_change);
        this.rnd = new Random(255);
        view.setBackgroundColor(Color.rgb(150, 100, 35));
        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uiChanger.ChangeUI(rnd.nextInt(), rnd.nextInt(), rnd.nextInt());
            }
        });

        return view;
    }


}
