package com.example.farza.gainzs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button savePriceButton = (Button)findViewById(R.id.storePriceButton);
        savePriceButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

    }
}
