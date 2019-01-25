package com.example.network;

import com.example.network.daggernetwork.DaggerNetworkComponent;
import com.example.network.daggernetwork.NetworkComponent;
import com.google.gson.Gson;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NetworkImpl<T> implements INetwork<T> {

    private OkHttpClient okHttpClient;
    private Gson gson;

    public NetworkImpl(String url){
        NetworkComponent component = DaggerNetworkComponent.builder().build();
        this.gson = component.getGson();
        this.okHttpClient = component.getOkHttpClient();
    }

    @Override
    public Observable<T> getRequest(final String url, final Class<T> tClass) {
        return Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> emitter) throws Exception {
                Request request = new Request.Builder().url(url).build();
                Response response = okHttpClient.newCall(request).execute();
                String json = response.body().string();
                T result = gson.fromJson(json, tClass);
                emitter.onNext(result);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
