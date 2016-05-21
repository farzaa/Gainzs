package com.example.farza.gainzs;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Tim on 5/21/2016.
 */
public class customAdapter extends ArrayAdapter<Restaurant>{

    Context context;
    int layResId;
    Restaurant[] restaurants = null;

    public customAdapter(Context context, int layoutResourceId, Restaurant[] restaurants) {

        super(context, layoutResourceId, restaurants);
        layResId = layoutResourceId;
        this.context = context;
        this.restaurants = restaurants;
    }

    public View getView(int position, View convertView, ViewGroup parent){

        View row = convertView;
        restaurantHolder theHolder = null;

        if(row == null){

            LayoutInflater inflate = ((Activity)context).getLayoutInflater();
            row = inflate.inflate(layResId,parent,false);

            theHolder = new restaurantHolder();
            theHolder.theImg = (ImageView)row.findViewById(R.id.theImg);
            theHolder.theText = (TextView)row.findViewById(R.id.theText);

            row.setTag(theHolder);
        }

        else
        {
            theHolder = (restaurantHolder)row.getTag();
        }

        Restaurant restaurant = restaurants[position];
        theHolder.theText.setText(restaurant.title);
        theHolder.theImg.setImageResource(restaurant.icon);

        return row;
    }

    static class restaurantHolder{

        ImageView theImg;
        TextView theText;
    }
}
