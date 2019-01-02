package com.example.erik.mvp_dagger.main;

import java.util.List;

public class IMain {
    public interface View{
        void updateUI(List<String> names);
        void setPresenter(IMain.Presenter presenter);
        void changeView(String dataToTransfer);
    }

    public interface Presenter{
        void setNames(List<String> names);
        void start();
        void changeView(int position);
    }
}
