package restraunt;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.farza.gainzs.MainActivity;
import com.example.farza.gainzs.R;
import com.example.farza.gainzs.Restaurant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestrauntViewActivity extends AppCompatActivity {
    EditText etResponse;
    TextView tvIsConnected;
    JSONObject reader;
    Restaurant restraunt;

    public boolean isConnected(){
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Activity.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
            return true;
        else
            return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail);

        //Hardcoded API calls because of time constraint. If this gets fucked it can take a bit to fix.

        //Call McDonalds

        //McDonalds Brand ID: 513fbc1283aa2dc80c000053
        //new HttpAsyncTask().execute("https://api.nutritionix.com/v1_1/item?id=23cb59492691b7e43efa59ac&appId=29623ac6&appKey=6164e57c2dab5743928cccd76e88fe2e");

        //Grab specificed food items for McDonalds
        new HttpAsyncTask().execute("https://api.nutritionix.com/v1_1/search/?brand_id=513fbc1283aa2dc80c000053&results=0%3A1&cal_min=0&cal_max=50000&fields=item_name%2Cbrand_name%2Citem_id%2Cbrand_id&appId=29623ac6&appKey=6164e57c2dab5743928cccd76e88fe2e");
        new HttpAsyncTask().execute("https://api.nutritionix.com/v1_1/search/Panera%20Bread?results=0%3A1&cal_min=0&cal_max=50000&fields=item_name%2Cbrand_name%2Citem_id%2Cbrand_id&appId=29623ac6&appKey=6164e57c2dab5743928cccd76e88fe2e");
    }
    public static String GET(String url)
    {
        InputStream inputStream = null;
        InputStream inputStream2 = null;
        String result = "";
        String reult2 = null;
        try {

            // create HttpClient

            // create HttpClient
            HttpClient httpclient = new DefaultHttpClient();

            // make GET request to the given URL
            HttpResponse httpResponse = httpclient.execute(new HttpGet(url));

            // receive response as inputStream
            inputStream = httpResponse.getEntity().getContent();
            // convert inputstream to string
            if(inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                result = "Did not work!";

        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }

        return result;
    }

    //This function needs to be able to go back to the main screen.
    //Button is functioning.
    public void finalButtonClicked(View v)
    {
        Log.d("tag", "Go back to view");
    }


    private static String convertInputStreamToString(InputStream inputStream) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;

    }

    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            return GET(urls[0]);
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getBaseContext(), "Received!", Toast.LENGTH_LONG).show();
            etResponse.setText(result);
            parseJson(result);
        }
    }

    private class HttpAsyncTask2 extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            return GET(urls[0]);
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getBaseContext(), "Received!", Toast.LENGTH_LONG).show();
            etResponse.setText(result);
            parseJson2(result);
        }
    }

    public void parseJson(String json) {
        try {

            //Grab JSON
            JSONObject object = new JSONObject(json);

            JSONArray hits = object.getJSONArray("hits");

            for(int i = 0; i < hits.length(); i++)
            {
                JSONObject fullMeal = hits.getJSONObject(i);
                Log.d("JSON", fullMeal.toString());

                String str = fullMeal.getString("_id");
                Log.d("ID", str);
                new HttpAsyncTask2().execute("https://api.nutritionix.com/v1_1/item?id=" + str + "&appId=29623ac6&appKey=6164e57c2dab5743928cccd76e88fe2e");
            }


        } catch (Exception e) {
            Log.e("Exception", e.toString());
            Log.d("JSON", "RIP");
        }

    }


    public void parseJson2(String json) {
        try {

            JSONObject object = new JSONObject(json);
            Log.d("JSON", object.toString());
            Log.d("JSON", object.getString("item_id"));

            double calories = Double.parseDouble(object.getString("nf_calories").toString());
            double fat = Double.parseDouble(object.getString("nf_protein").toString());
            double sugar = Double.parseDouble(object.getString("nf_sugars").toString());
            double protein = Double.parseDouble(object.getString("nf_protein").toString());

            //Once we have the info, add it as a new meal.
            restraunt.addNewMeal(calories, sugar, protein, fat);

            Log.d("JSON", "HERE");


        } catch (Exception e) {
            Log.e("Exception", e.toString());
            Log.d("JSON", "RIP");
        }


    }

}
