package com.midtermmad3125.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.midtermmad3125.R;
import com.midtermmad3125.utils.ReadJSONUtils;
import com.midtermmad3125.utils.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MainCityActivity extends AppCompatActivity
{
    List<Weather> w = new ArrayList<>();

    TextView t1,t2,t3,t4,t5;
    Button b1;
    Weather w1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.weatherdetail);
        t1 = findViewById(R.id.cityname);
        t2 = findViewById(R.id.latitude);
        t1.setText(w1.getMcountry());
        t2.setText(w1.getMcity());


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainCityActivity.this,WeatherListActivity.class);
                startActivity(i);
            }
        });
        processJSON();






    }
    private void processJSON(){


        List<Weather> w = new ArrayList<>();
        String jsonString = loadJSONFromAsset();
        if(jsonString!=null){
            try {
                JSONObject mJSONArray = new JSONObject(jsonString);

                JSONObject city=mJSONArray.getJSONObject("city");
                Log.d("sssssssssssss",city.getString("id"));
                   // String mJSONObject = mJSONArray.getString("city");
                for(int i=0;i<=city.length();i++){
                   // JSONObject currentnews=mJSONObject.getJSONObject(i);
                    String nwid=city.getString("id");
                    String nwname=city.getString("name");
                    String nwcoord=city.getString("coord");
                    String nwcountry=city.getString("country");
                    Weather nw =new Weather(nwid,nwname,nwcountry,nwcoord,nwid,nwname,nwcoord);
                    Log.d("----JSON----",nwid);
                    Log.d("----JSON----",nwname);
                    Log.d("----JSON----",nwcoord);
                    Log.d("----JSON----",nwcountry);



                    w.add(nw);

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
