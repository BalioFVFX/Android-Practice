package com.example.erik.rxandroid;

import android.annotation.SuppressLint;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.reactivestreams.Subscription;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private DataPicker dataPicker;
    private Disposable disposable;
    private Button button;
    private ProgressBar progressBar;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.dataPicker = new DataPicker();
        this.textView = (TextView)findViewById(R.id.tv_info);
        this.progressBar = (ProgressBar)findViewById(R.id.progress_bar);
        this.button = (Button)findViewById(R.id.btn_clickable);
        this.setButtonListener();

    }

    private void setButtonListener(){
        this.button.setOnClickListener(v ->{
            this.disposable = this.dataPicker.getData()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe(new Consumer<Disposable>() {
                        @Override
                        public void accept(Disposable disposable) throws Exception {
                            progressBar.setVisibility(View.VISIBLE);
                            button.setVisibility(View.INVISIBLE);
                            textView.setText("Generating numbers...");
                        }
                    })
                    .subscribe(data -> {
                        this.textView.setText(data);
                        progressBar.setVisibility(View.GONE);
                        this.button.setVisibility(View.VISIBLE);
                    });
        });
    }

    @Override
    protected void onDestroy() {
        disposable.dispose();
        super.onDestroy();
    }
}
