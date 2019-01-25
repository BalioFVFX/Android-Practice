package com.example.network;

import io.reactivex.Observable;

public interface INetwork<T> {
    Observable<T> getRequest(final String url, Class<T> tClass);
}
