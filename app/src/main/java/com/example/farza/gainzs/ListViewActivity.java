package com.example.farza.gainzs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import restraunt.RestrauntViewActivity;

public class ListViewActivity extends AppCompatActivity {

    Restaurant restaurants[] = new Restaurant[]
            {
                    new Restaurant(R.mipmap.ic_launcher, "Restaurant One"),
                    new Restaurant(R.mipmap.ic_launcher, "Restaurant Two"),
                    new Restaurant(R.mipmap.ic_launcher, "Restaurant Three"),
                    new Restaurant(R.mipmap.ic_launcher, "Restaurant Four"),
                    new Restaurant(R.mipmap.ic_launcher, "Restaurant Five"),
                    new Restaurant(R.mipmap.ic_launcher, "Restaurant Six"),
                    new Restaurant(R.mipmap.ic_launcher, "Restaurant Seven"),
                    new Restaurant(R.mipmap.ic_launcher, "Restaurant Eight")
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
                Intent screenAfterList = new Intent(ListViewActivity.this, MainActivity.class);
                screenAfterList.putExtra("positionList", pos);
                //ListEntry listEntry = new Li
                startActivity(screenAfterList);
            }
        });
    }
}
