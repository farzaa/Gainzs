package com.example.farza.gainzs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
                TextView error = (TextView)findViewById(R.id.errorMessage);
                EditText userInput = (EditText)findViewById(R.id.inputText);

                //-- Check for input --//
                String inputString = userInput.getText().toString();

                if(inputString.matches("")) {
                    error.setText("YOU FOOL! ENTER SOMETHING");
                    return;
                } else {
                    error.setText("");
                }

                Intent listOfRestaurants = new Intent(MainActivity.this, ListViewActivity.class);
                startActivity(listOfRestaurants);
            }
        });

    }
}
