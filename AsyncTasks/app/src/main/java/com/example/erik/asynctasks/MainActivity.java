package com.example.erik.asynctasks;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.erik.asynctasks.model.Data;
import com.example.erik.asynctasks.model.Player;
import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static String url;

    private EditText playerInfoEditText;
    private Button findPlayerButton;
    private TextView playerNameTextView;
    private TextView platformTextView;
    private TextView gameTextView;
    private CheckBox nameCheckBox;
    private CheckBox platformCheckBox;
    private CheckBox gameCheckBox;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initViews();
        this.initListeners();
    }

    private void initViews(){
        this.playerInfoEditText = (EditText)findViewById(R.id.et_find_player);
        this.findPlayerButton = (Button)findViewById(R.id.btn_find_player);

        this.playerNameTextView = (TextView)findViewById(R.id.tv_name);
        this.platformTextView = (TextView)findViewById(R.id.tv_plat);
        this.gameTextView = (TextView)findViewById(R.id.tv_game);

        this.nameCheckBox = (CheckBox)findViewById(R.id.chb_name);
        this.platformCheckBox = (CheckBox)findViewById(R.id.chb_platform);
        this.gameCheckBox = (CheckBox)findViewById(R.id.chb_game);

        this.progressBar = (ProgressBar)findViewById(R.id.progress_load);
    }
    private void initListeners(){
        this.findPlayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String platform = "pc";
                String username = playerInfoEditText.getText().toString().trim();
                url = String.format("https://api.bf4stats.com/api/playerInfo?plat=%s&name=%s&output=json",
                        platform, username);
                new AsyncManager(getApplicationContext()).execute();
            }
        });
    }
    private class AsyncManager extends AsyncTask<String, Integer, Player> {
        private Context context;

        public AsyncManager(Context context) {
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
            playerNameTextView.setText(R.string.tv_no_info);
            platformTextView.setText(R.string.tv_no_info);
            gameTextView.setText(R.string.tv_no_info);

            nameCheckBox.setChecked(false);
            platformCheckBox.setChecked(false);
            gameCheckBox.setChecked(false);
        }



        @Override
        protected Player doInBackground(String... strings) {
            OkHttpClient okHttpClient = new OkHttpClient();

            Request request = new Request.Builder().url(url).build();

            try {
                Response response = okHttpClient.newCall(request).execute();
                String result = response.body().string();
                Gson gson = new Gson();
                Data data = gson.fromJson(result, com.example.erik.asynctasks.model.Data.class);
                return data.getPlayer();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Player player) {
            if(player == null){
                Toast.makeText(context, "Player not found!", Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.INVISIBLE);
                return;
            }
            playerNameTextView.setText(String.format("Username - %s", player.getName()));
            platformTextView.setText(String.format("Platform - %s", player.getPlat().toUpperCase()));
            gameTextView.setText(String.format("Game - %s", player.getGame().toUpperCase()));

            nameCheckBox.setChecked(true);
            platformCheckBox.setChecked(true);
            gameCheckBox.setChecked(true);

            progressBar.setVisibility(View.INVISIBLE);
        }
    }

}
