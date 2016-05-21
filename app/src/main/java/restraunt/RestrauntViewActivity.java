package restraunt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.farza.gainzs.MainActivity;
import com.example.farza.gainzs.R;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class RestrauntViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_list);
    }

    //This function needs to be able to go back to the main screen.
    //Button is functioning.
    public void finalButtonClicked(View v)
    {
        Log.d("tag", "Go back to view");
    }




}
