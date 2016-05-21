package com.example.farza.gainzs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Restaurant_detail extends AppCompatActivity {



    //int position = i.getIntExtra("positionList", 0);
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent i = getIntent();
        int a = i.getIntExtra("positionList",1);
        Toast.makeText(getBaseContext()," " + a ,Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail);
        //int a = extras.getInt("positionList", 0);

    }
}
