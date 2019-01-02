package com.example.erik.mvp_dagger.main;

import java.util.List;

public class MainPresenter implements IMain.Presenter{

    private IMain.View mainView;
    private List<String> names;


    public MainPresenter(IMain.View mainView) {
        this.mainView = mainView;
    }

    @Override
    public void setNames(List<String> names) {
        this.names = names;
    }

    @Override
    public void start() {
        mainView.updateUI(names);
    }

    @Override
    public void changeView(int position) {
        mainView.changeView(this.names.get(position));
    }
}
