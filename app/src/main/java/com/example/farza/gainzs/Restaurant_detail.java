package com.example.farza.gainzs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.farza.gainzs.Models.SingleMeal;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Restaurant_detail extends AppCompatActivity {



    //int position = i.getIntExtra("positionList", 0);
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent i = getIntent();
        int position = i.getIntExtra("positionList",1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail);

        //-- Get mealsList data --//
        Restaurant [] res = new Restaurant[1];

        Restaurant newRestaurant = new Restaurant(R.drawable.md,"McDonalds");

        TextView calorieText = (TextView)findViewById(R.id.calorieView);
        double finalValue = 0;

        for(int j = 0; j < res.length; j++) {
            double sum = newRestaurant.mealList.get(j).calories;
            finalValue += sum;
        }
        //-- List Logic --//
        calorieText.setText(Double.toString(finalValue));

    }
}
