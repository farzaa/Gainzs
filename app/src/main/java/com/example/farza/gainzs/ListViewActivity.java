package com.example.farza.gainzs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import restraunt.RestrauntViewActivity;

public class ListViewActivity extends AppCompatActivity {

    Restaurant restaurants[] = new Restaurant[]
            {
                    new Restaurant(R.mipmap.mcd, "McDonald's"),
                    new Restaurant(R.mipmap.mcd, "McDonald's"),
                    new Restaurant(R.mipmap.mcd, "McDonald's"),
                    new Restaurant(R.mipmap.mcd, "McDonald's"),
                    new Restaurant(R.mipmap.mcd, "McDonald's"),
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

        listy.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int pos = parent.getPositionForView(view);
                Toast.makeText(getBaseContext(), "You've tapped element " + pos, Toast.LENGTH_SHORT ).show();
                Intent screenAfterList = new Intent(ListViewActivity.this, Restaurant_detail.class);
                screenAfterList.putExtra("positionList", pos);
                //ListEntry listEntry = new Li
                startActivity(screenAfterList);
            }
        });
    }
}
