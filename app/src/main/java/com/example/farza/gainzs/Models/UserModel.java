package com.example.farza.gainzs.Models;

/**
 * Created by alecdilanchian on 5/21/16.
 */

import android.util.Log;

public class UserModel {
    private double userPriceInput;

    public void getPriceInput(double userInput) {
        userPriceInput = userInput;

        Log.d("userInput", String.valueOf(userPriceInput));
    }
}
