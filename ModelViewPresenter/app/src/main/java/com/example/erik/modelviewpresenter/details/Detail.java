package com.example.erik.modelviewpresenter.details;

public class Detail {
    public interface View{
        void setPresenter(Detail.Presenter presenter);
        void updateText(String text);
    }
    public interface Presenter{
        Detail.View getView();
        void start();
        void setName(String txt);
    }
}
