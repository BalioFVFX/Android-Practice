package com.example.erik.rxandroid;

import android.os.SystemClock;
import android.util.Log;

import java.util.Random;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class DataPicker {
    public Observable<String> getData(){
        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                Log.d("INFO", "Waiting for data to arrive");
                SystemClock.sleep(5000);
                Random random = new Random();
                emitter.onNext("Numbers: " + random.nextInt());
            }
        });
    }
}
