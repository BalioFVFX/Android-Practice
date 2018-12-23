package com.example.erik.gesture_and_touch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView)findViewById(R.id.list_view_id);
        final ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(stringArrayAdapter);

        this.gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener(){
            @Override
            public void onLongPress(MotionEvent e) {
                Toast.makeText(MainActivity.this, "Long Press", Toast.LENGTH_SHORT).show();
                stringArrayAdapter.add("On Long Press");
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                if(e1.getX() - e2.getX() < e2.getX() && Math.abs(velocityX) > Math.abs(velocityY)){
                    Toast.makeText(MainActivity.this, "Left To Right", Toast.LENGTH_SHORT).show();
                    stringArrayAdapter.add("Left To Right");
                    return true;
                }
                if(e1.getX() - e2.getX() > e2.getX() && Math.abs(velocityX) > Math.abs(velocityY)){
                    Toast.makeText(MainActivity.this, "Right To Left", Toast.LENGTH_SHORT).show();
                    stringArrayAdapter.add("Right To Left");
                    return true;
                }

                return false;
            }
        });

        listView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return onTouchEvent(event);
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return this.gestureDetector.onTouchEvent(event);
    }
}
