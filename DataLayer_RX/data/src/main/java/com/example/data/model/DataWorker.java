package com.example.data.model;

import com.google.gson.Gson;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DataWorker <T> implements IData {
    private final Class<T[]> tClassArray;
    private String url;
    private Class<T> tClass;
    private Gson gson;
    private OkHttpClient httpClient;
    public DataWorker(String url, Class<T> tClass, Class<T[]> tClassArray){
        this.url = url;
        this.tClass = tClass;
        this.tClassArray = tClassArray;
        this.gson = new Gson();
        this.httpClient = new OkHttpClient();
    }

    @Override
    public Observable<T[]> getAll() {
        return Observable.create(new ObservableOnSubscribe() {
            @Override
            public void subscribe(ObservableEmitter emitter) throws Exception {
                Request request = makeRequest();
                Response response = httpClient.newCall(request).execute();
                T[] result = mapToObjects(response.body().string());
                emitter.onNext(result);
            }
        });
    }

    private Request makeRequest(){
        return new Request
                .Builder()
                .url(url)
                .build();
    }

    private T[] mapToObjects(final String json){
        return this.gson.fromJson(json, tClassArray);
    }
}
