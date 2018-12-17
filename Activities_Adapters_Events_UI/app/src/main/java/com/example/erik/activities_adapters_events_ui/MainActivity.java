package com.example.erik.activities_adapters_events_ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button firstButton;
    Button secondButton;
    EditText firstEditText;
    TextView firstTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.firstButton = (Button)this.findViewById(R.id.btn_first);
        this.firstEditText = (EditText)this.findViewById(R.id.et_first);
        this.firstTextView = (TextView)this.findViewById(R.id.tv_first);
        this.secondButton = (Button)this.findViewById(R.id.btn_second);
        this.attachEventListener();

    }

    private void attachEventListener(){
        this.firstButton.setOnClickListener(view -> {
            this.firstTextView.setText(this.firstEditText.getText());
            this.firstEditText.setText("");
        });

        this.secondButton.setOnClickListener(v -> {
           Intent intent = new Intent(this, DetailActivity.class);
           startActivity(intent);
        });
    }
}
