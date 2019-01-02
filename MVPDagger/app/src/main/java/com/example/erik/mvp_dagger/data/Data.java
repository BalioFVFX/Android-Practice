package com.example.erik.mvp_dagger.data;

import java.util.ArrayList;
import java.util.List;

public class Data {
    private List<String> names;

    public Data() {
        this.names = new ArrayList<>();
        this.names.add("John");
        this.names.add("Jane");
        this.names.add("Rob");
    }

    public String getById(int id){
        return this.names.get(id);
    }

    public void add(String name){
        this.names.add(name);
    }

    public List<String> getAll(){
        return new ArrayList<>(names);
    }
}
