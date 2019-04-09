package com.midtermmad3125.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.midtermmad3125.R;
import com.midtermmad3125.utils.ReadJSONUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class MainCityActivity extends AppCompatActivity
{
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.weatherdetail);
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
        String jsonString = loadJSONFromAsset();
        if(jsonString!=null){
            try {
                JSONObject mJSONArray = new JSONObject(jsonString);


                    JSONObject mJSONObject = mJSONArray.getJSONObject("city");
                    if(mJSONObject.has("city")) {
                       Log.d("s")
                    }

                  //  String name = mJSONObject.getString("name");

                   // Log.d("----JSON----",name);
                    //read address json Object
                 //   JSONObject mAddress = mJSONObject.getJSONObject("address");
                 //   String city = mAddress.getString("city");
                  //  Log.d("----JSON----",city);


                }

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
