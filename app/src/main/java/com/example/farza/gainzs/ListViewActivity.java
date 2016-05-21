package com.example.farza.gainzs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewActivity extends AppCompatActivity {

    Restaurant restaurants[] = new Restaurant[]
            {
                    new Restaurant(R.mipmap.ic_launcher, "Cloudy"),
                    new Restaurant(R.mipmap.ic_launcher, "Showers"),
                    new Restaurant(R.mipmap.ic_launcher, "Snow"),
                    new Restaurant(R.mipmap.ic_launcher, "Storm"),
                    new Restaurant(R.mipmap.ic_launcher, "Sunny"),
                    new Restaurant(R.mipmap.ic_launcher, "Cloudy"),
                    new Restaurant(R.mipmap.ic_launcher, "Showers"),
                    new Restaurant(R.mipmap.ic_launcher, "Snow"),
                    new Restaurant(R.mipmap.ic_launcher, "Storm"),
                    new Restaurant(R.mipmap.ic_launcher, "Sunny"),
                    new Restaurant(R.mipmap.ic_launcher, "Cloudy"),
                    new Restaurant(R.mipmap.ic_launcher, "Showers"),
                    new Restaurant(R.mipmap.ic_launcher, "Snow"),
                    new Restaurant(R.mipmap.ic_launcher, "Storm"),
                    new Restaurant(R.mipmap.ic_launcher, "Sunny"),
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //Log.d("Yoooo", "Did we get here");
        customAdapter adapter = new customAdapter(

                this,

                R.layout.activity_list_view,

                restaurants
        );

        ListView listy = (ListView)findViewById(R.id.restaurant_listView);

        listy.setAdapter(adapter);
    }
}
