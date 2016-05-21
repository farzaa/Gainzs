package com.example.farza.gainzs;

import android.util.Log;

import com.example.farza.gainzs.Models.SingleMeal;

import java.util.ArrayList;

/**
 * Created by Tim on 5/21/2016.
 */
public class Restaurant {

    public int icon;
    public String title;
    public ArrayList<SingleMeal> mealList = new ArrayList<SingleMeal>();

    public Restaurant(){
        super();
    }

    public Restaurant(int icon, String title){

        super();
        this.icon = icon;
        this.title = title;
    }

    public void addNewMeal(double calories, double sugar, double protein, double fat)
    {
        SingleMeal meal = new SingleMeal();
        meal.calories = calories;
        meal.sugar = sugar;
        meal.protein = protein;
        meal.fat = fat;
        mealList.add(meal);


        Log.d("myTag", Double.toString(mealList.get(0).calories));
        Log.d("myTag", Double.toString(mealList.get(0).sugar));
        Log.d("myTag", Double.toString(mealList.get(0).protein));
        Log.d("myTag", Double.toString(mealList.get(0).fat));
    }
}
