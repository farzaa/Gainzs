package com.example.farza.gainzs;

import com.example.farza.gainzs.Models.SingleMeal;

import java.util.ArrayList;

/**
 * Created by Tim on 5/21/2016.
 */
public class Restaurant {

    public int icon;
    public String title;
    ArrayList<SingleMeal> mealList;

    public Restaurant(){
        super();
    }

    public Restaurant(int icon, String title){

        super();
        this.icon = icon;
        this.title = title;
    }

    public void setMealList()
    {
    }
}
