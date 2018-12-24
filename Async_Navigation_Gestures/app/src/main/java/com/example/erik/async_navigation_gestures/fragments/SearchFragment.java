package com.example.erik.async_navigation_gestures.fragments;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.erik.async_navigation_gestures.IWeather;
import com.example.erik.async_navigation_gestures.R;
import com.example.erik.async_navigation_gestures.Weather;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment
implements IName{


    private Button searchButton;
    private EditText searchEditText;
    private IWeather iWeather;


    public SearchFragment() {
        // Required empty public constructor
    }

    public static SearchFragment newInstance(IWeather iWeather){
        SearchFragment searchFragment = new SearchFragment();
        searchFragment.iWeather = iWeather;
        return searchFragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_search, container, false);
        this.searchButton = (Button)view.findViewById(R.id.btn_search);
        this.searchEditText = (EditText)view.findViewById(R.id.et_town_name);
        searchListener();
        return view;
    }


    private void searchListener(){
        this.searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://api.openweathermap.org/data/2.5/weather?q=%s&APPID=10885e4a556baaa10a716567518c894e&units=metric";
                new AsyncTaskManager().execute(String.format(url, searchEditText.getText().toString().trim()));
            }
        });
    }


    @Override
    public String getFragmentName() {
        return "Search";
    }

    private class AsyncTaskManager extends AsyncTask<String, Integer, Weather>{



        @Override
        protected Weather doInBackground(String... strings) {

            try {
                Gson gson = new Gson();
                OkHttpClient okHttpClient = new OkHttpClient();
                Request request = new Request.Builder().url(strings[0]).build();
                Response response = okHttpClient.newCall(request).execute();
                Weather weather = gson.fromJson(response.body().string(), Weather.class);
                return weather;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Weather weather) {
            if(weather.getMain() == null){
                Toast.makeText(getContext(), "Invalid data!", Toast.LENGTH_LONG).show();
                return;
            }
            iWeather.updateWeatherTextView(weather.getMain().getTemp().toString());
        }
    }
}
