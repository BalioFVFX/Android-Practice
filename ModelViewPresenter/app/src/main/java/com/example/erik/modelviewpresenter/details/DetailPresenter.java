package com.example.erik.modelviewpresenter.details;

public class DetailPresenter implements Detail.Presenter {

    private final Detail.View view;
    private String name;

    public DetailPresenter(Detail.View view) {
        this.view = view;
        this.view.setPresenter(this);
    }

    @Override
    public Detail.View getView() {
        return this.view;
    }

    @Override
    public void start() {
        this.getView().updateText(name);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
