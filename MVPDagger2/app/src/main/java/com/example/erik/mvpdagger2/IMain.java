package com.example.erik.mvpdagger2;

import com.example.network.models.Activity;

public class IMain {
    public interface View{
        void setPresenter(IMain.Presenter presenter);
        void updateViews(Activity activity);
    }

    public interface Presenter{
        void start();
        IMain.View getView();
        void getRandomActivity();
    }
}
