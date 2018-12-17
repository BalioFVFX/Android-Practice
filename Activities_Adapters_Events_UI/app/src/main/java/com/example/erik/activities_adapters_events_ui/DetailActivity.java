package com.example.erik.activities_adapters_events_ui;

import android.app.ListActivity;
import com.example.erik.activities_adapters_events_ui.entity.Person;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import es.dmoral.toasty.Toasty;

public class DetailActivity extends AppCompatActivity {

    private final Person[] humans = {new Person("Pesho", 10), new Person("Gosho", 20), new Person("Tosho", 30)};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ListView listView = (ListView)this.findViewById(R.id.lv_first);
        listView.setTextFilterEnabled(true);
        listView.setAdapter(new MySuperCustomAdapter(this, humans));
        listView.setOnItemClickListener((parent, view, position, value) -> {
            Toasty.info(this, String.format("is %s years old.", humans[position].getAge()), Toast.LENGTH_LONG, true).show();
        });
    }
}
