package com.example.farza.gainzs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import com.blackcat.currencyedittext.CurrencyEditText;
import com.example.farza.gainzs.Models.UserModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button savePriceButton = (Button)findViewById(R.id.storePriceButton);
        savePriceButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CurrencyEditText userInput = (CurrencyEditText)findViewById(R.id.textInput);
                Long rawData = userInput.getRawValue();

                //-- Check for input --//
                if(rawData.toString().matches("0")) {
                    Toast.makeText(getBaseContext(), "You forgot to enter a value!", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    UserModel newUser = new UserModel();
                    newUser.setPriceInput(rawData);
                }

                Intent listOfRestaurants = new Intent(MainActivity.this, ListViewActivity.class);
                startActivity(listOfRestaurants);
            }
        });

    }
}
