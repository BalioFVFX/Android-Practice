package com.example.erik.services;

import android.app.IntentService;
import android.content.Intent;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;


import java.util.logging.Handler;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainService extends IntentService {

    private CompositeDisposable compositeDisposable;
    public MainService() {
        super("default");
        this.compositeDisposable = new CompositeDisposable();
    }

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public MainService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        for (int i = 1; i <= 10; i++) {
            try {
                compositeDisposable.add(Observable.just(i).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<Integer>() {
                            @Override
                            public void accept(Integer integer) throws Exception {
                                Toast.makeText(getApplicationContext(), String.format("Iterator - %s", integer), Toast.LENGTH_SHORT).show();
                                Log.d("INFO", " Iterator - " + integer);
                            }
                        }));
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestory() service", Toast.LENGTH_SHORT).show();
        this.compositeDisposable.clear();
    }
}
