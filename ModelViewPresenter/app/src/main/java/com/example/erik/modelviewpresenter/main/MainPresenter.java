package com.example.erik.modelviewpresenter.main;

public class MainPresenter implements Main.Presenter {

    private Main.View view;
    private String[] data;


    public MainPresenter(Main.View view) {
        this.view = view;
        this.view.setPresenter(this);
        this.data = new String[] {"Jaycob Warren", "Andrew Gardner", "Riley Davies", "Jack Stewart"};
    }

    @Override
    public Main.View getView() {
        return this.view;
    }

    @Override
    public void start() {
        this.getView().setData(this.data);
    }

    @Override
    public void getClickedItem(int position) {
        this.getView().navigate(this.data[position]);
    }


}
