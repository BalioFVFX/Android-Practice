package com.example.erik.mvp_dagger.detail;

public class IDetail {
    public interface View{
        void setPresenter(IDetail.Presenter presenter);
        void setName(String name);
    }
    public interface Presenter{
        void start();
        void setName(String name);
    }
}
