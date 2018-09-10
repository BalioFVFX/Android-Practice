package com.example.erik.anonymousclassesdifferentwaystoimplementabuttonlistener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    public void onClick(View view) {
        Toast.makeText(this, "Current class that implements View.OnClickListener, passing (this) as parameter", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 01 Other class that implements View.OnClickListener
        // Passing the object, because it's class implements View.OnClickListener

        Buttoner buttoner = new Buttoner();
        Button button1 = findViewById(R.id.button);

        button1.setOnClickListener(buttoner);

        // 02 Current class implements View.OnClickListener,
        // So the parameter will be (this)

        Button button2 = findViewById(R.id.button2);

        button2.setOnClickListener(this);

        // 03 Anonymous implementation

        Button button3 = findViewById(R.id.button3);

        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Anonymous implementation, passing the interface implementation itself as parameter", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
