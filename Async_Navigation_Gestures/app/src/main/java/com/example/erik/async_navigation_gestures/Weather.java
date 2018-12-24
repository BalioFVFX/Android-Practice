package com.example.erik.async_navigation_gestures;

import com.google.gson.annotations.SerializedName;

public class Weather {
   @SerializedName("main")
    private Main main;

    public Weather() {
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
