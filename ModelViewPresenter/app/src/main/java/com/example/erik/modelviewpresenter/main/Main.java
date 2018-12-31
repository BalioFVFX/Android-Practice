package com.example.erik.modelviewpresenter.main;

public class Main {
    public interface View{
        void setPresenter(Main.Presenter presenter);
        void showData(String data);
        void setData(String[] data);
        void navigate(String name);
    }

    public interface Presenter{
        Main.View getView();
        void start();
        void getClickedItem(int position);
    }
}
