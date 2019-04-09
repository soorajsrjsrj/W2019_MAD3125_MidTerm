package com.midtermmad3125.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.midtermmad3125.R;
import com.midtermmad3125.utils.ListWeather;
import com.midtermmad3125.utils.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class WeatherListActivity extends AppCompatActivity
{
    List<ListWeather> lw = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_list);

        processJSON();
        ArrayList<ListWeather> weatherlist = new ArrayList<ListWeather>();
// Create the adapter to convert the array to views
        weatherAdapter adapter = new weatherAdapter(WeatherListActivity.this,weatherlist);
// Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.lvItems);
        listView.setAdapter(adapter);


    }
    private void processJSON(){



        String jsonString = loadJSONFromAsset();
        if(jsonString!=null){
            try {
                JSONObject mJSONArray = new JSONObject(jsonString);

                JSONArray city=mJSONArray.getJSONArray("list");
                for(int i=0;i<city.length();i++){
                JSONObject list = city.getJSONObject(i);

              //  String
              //  Log.d("sssssssssssss",city.getString("id"));
                // String mJSONObject = mJSONArray.getString("city");

                    // JSONObject currentnews=mJSONObject.getJSONObject(i);
                    String nwdt=list.getString("dt");
                    String nwpressure=list.getString("pressure");
                    String nwhumidity=list.getString("humidity");
                    String nwspeed=list.getString("speed");
                    Log.d("sssssssssssss",list.getString("speed"));

                    Log.d("----JSON----",nwdt);
                    Log.d("----JSON----",nwpressure);
                    Log.d("----JSON----",nwhumidity);
                    Log.d("----JSON----",nwspeed);
                    ListWeather lsw = new ListWeather(nwdt,nwpressure,nwhumidity,nwspeed);



                    lw.add(lsw);

                }


                //  String name = mJSONObject.getString("name");

                // Log.d("----JSON----",name);
                //read address json Object
                //   JSONObject mAddress = mJSONObject.getJSONObject("address");
                //   String city = mAddress.getString("city");
                //  Log.d("----JSON----",city);




            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
    public String loadJSONFromAsset() {
        String jsonString;
        try {
            InputStream is = getAssets().open("moscow_weather.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            int count = is.read(buffer);
            is.close();
            jsonString = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return jsonString;
    }




}
