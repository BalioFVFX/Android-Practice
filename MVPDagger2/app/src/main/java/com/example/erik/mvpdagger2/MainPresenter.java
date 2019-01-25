package com.example.erik.mvpdagger2;

import com.example.network.INetwork;
import com.example.network.NetworkImpl;
import com.example.network.daggernetwork.DaggerNetworkComponent;
import com.example.network.daggernetwork.NetworkComponent;
import com.example.network.models.Activity;


import io.reactivex.functions.Consumer;

public class MainPresenter implements IMain.Presenter{

    private final String url;
    private final IMain.View view;
    private final INetwork<Activity> network;
    public MainPresenter(IMain.View view){
        NetworkComponent component = DaggerNetworkComponent.builder().build();
        this.view = view;
        this.url = "https://www.boredapi.com/api/activity";
        this.network = component.getNetwork();
    }

    @Override
    public void start() {
    }

    @Override
    public IMain.View getView() {
        return this.view;
    }

    @Override
    public void getRandomActivity() {
        this.network.getRequest(url, Activity.class)
                .subscribe(new Consumer<Activity>() {
                    @Override
                    public void accept(Activity activity) throws Exception {
                        view.updateViews(activity);
                    }
                });
    }

}
