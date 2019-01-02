package com.example.erik.mvp_dagger.detail;

public class DetailPresenter implements IDetail.Presenter{

    private final IDetail.View detailView;
    private String name;

    public DetailPresenter(IDetail.View view){
        this.detailView = view;
    }

    @Override
    public void start() {
        this.detailView.setName(name);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
