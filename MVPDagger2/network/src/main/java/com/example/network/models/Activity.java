package com.example.network.models;

public class Activity {
    private String activity;
    private String type;
    private Float accessibility;
    private Double price;


    public Activity() {
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getType() {
        return this.type.toUpperCase().charAt(0) + this.type.substring(1);
    }

    public void setType(String type) {
        this.type = type;
    }

    public Float getAccessibility() {
        return accessibility;
    }

    public void setAccessibility(Float accessibility) {
        this.accessibility = accessibility;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
