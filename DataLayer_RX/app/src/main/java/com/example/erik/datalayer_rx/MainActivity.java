package com.example.erik.datalayer_rx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.data.model.DataWorker;
import com.example.data.model.IData;
import com.example.data.model.User;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private static final String url = "http://jsonplaceholder.typicode.com/users";
    private Disposable disposable;
    private Button button;
    private ListView listView;
    private IData<User> data;
    private ProgressBar progressBar;
    private UserAdapter userUserAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.data = new DataWorker(url, User.class, User[].class);
        this.listView = findViewById(R.id.lv_users);
        this.button = (Button)findViewById(R.id.btn_users);
        this.progressBar = (ProgressBar)findViewById(R.id.progress_bar);
        List<User> users = new ArrayList<>();
        this.userUserAdapter = new UserAdapter(this, users);
        setButtonListener(users);

        listView.setAdapter(new UserAdapter(this, users));

    }

    private void setButtonListener(List<User> users){

        this.button.setOnClickListener(v -> {
            this.disposable = data.getAll()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe(disposable1 -> {
                        progressBar.setVisibility(View.VISIBLE);
                    })
                    .subscribe(u -> {
                        users.clear();
                        for (User user : u){
                            users.add(user);
                        }
                        listView.invalidateViews();
                        progressBar.setVisibility(View.GONE);
                    });
        });
    }

    @Override
    protected void onDestroy() {
        this.disposable.dispose();
        super.onDestroy();
    }
}
