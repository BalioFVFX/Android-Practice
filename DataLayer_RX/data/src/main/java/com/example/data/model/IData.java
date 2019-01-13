package com.example.data.model;

import io.reactivex.Observable;

public interface IData <T>{
    Observable<T[]> getAll();
}
