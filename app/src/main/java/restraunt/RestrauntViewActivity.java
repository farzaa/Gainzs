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

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
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
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_list);

        tvIsConnected = (TextView) findViewById(R.id.tvIsConnected);
        etResponse = (EditText) findViewById(R.id.etResponse);


        if(isConnected())
        {
            tvIsConnected.setBackgroundColor(0xFF00CC00);
            tvIsConnected.setText("You are connected");
        }

        else
        {
            tvIsConnected.setText("You are NOT conncted");
        }

        new HttpAsyncTask().execute("http://hmkcode.appspot.com/rest/controller/get.json");

    }

    public static String GET(String url)
    {
        InputStream inputStream = null;
        String result = "";
        try {

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

    public boolean isConnected(){
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Activity.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
            return true;
        else
            return false;
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
        }
    }

//    //Method to actually go and GET data via a URL.
//    private String downloadUrl(String myurl) throws IOException {
//        InputStream is = null;
//        int len = 10;
//
//        try
//        {
//            URL url = new URL(myurl);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setReadTimeout(10000 /* milliseconds */);
//            conn.setConnectTimeout(15000 /* milliseconds */);
//            conn.setRequestMethod("GET");
//            conn.setDoInput(true);
//
//            // Starts the query
//            conn.connect();
//            int response = conn.getResponseCode();
//            Log.d("Network Tag", "The response is: " + response);
//            is = conn.getInputStream();
//
//            // Convert the InputStream into a string
//            //String contentAsString = readIt(is, len);
//            //return contentAsString;
//
//            Log.d("Oh god", is.toString());
//
//            // Makes sure that the InputStream is closed after the app is
//            // finished using it.
//
//            if (is != null)
//            {
//                is.close();
//            }
//        }
//
//        catch(Exception e)
//        {
//            Log.e("Exception", e.toString());
//        }
//
//        return is.toString();
//    }



}
