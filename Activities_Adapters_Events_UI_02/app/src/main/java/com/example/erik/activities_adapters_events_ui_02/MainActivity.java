package com.example.erik.activities_adapters_events_ui_02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.erik.activities_adapters_events_ui_02.entity.Person;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {

    private EditText et_names;
    private Button btn_names;
    private TextView tv_names;
    private Button btn_details;
    public static List<Person> persons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initWidgets();
        this.setButtonListener();
        persons = new ArrayList<Person>();
    }

    private void initWidgets() {
        this.et_names = (EditText) this.findViewById(R.id.et_names);
        this.btn_names = (Button) this.findViewById(R.id.btn_add_name);
        this.tv_names = (TextView) this.findViewById(R.id.tv_names_count);
        this.btn_details = (Button) this.findViewById(R.id.btn_details);
    }

    private void setButtonListener() {
        this.btn_names.setOnClickListener(v -> {
            String[] firstLastNames = this.et_names.getText().toString().split(" ");
            Person person;
            if (firstLastNames.length > 1) {
                person = new Person(firstLastNames[0], firstLastNames[1]);
                persons.add(person);
            } else {
                if (firstLastNames[0].equals("")){
                    Toasty.error(getApplicationContext(), "Cannot add empty text!", Toast.LENGTH_SHORT).show();
                    return;
                }
                person = new Person(firstLastNames[0]);
                persons.add(person);
            }

            this.et_names.setText("");
            this.tv_names.setText(String.format("Names added: %s", persons.size()));
            Toasty.success(getApplicationContext(), String.format("%s %s", person.getFirstName(), person.getLastName()), Toast.LENGTH_SHORT).show();
        });

        this.btn_details.setOnClickListener(v -> {
            Intent intent = new Intent(this, DetailActivity.class);
            startActivity(intent);
        });

    }
}
