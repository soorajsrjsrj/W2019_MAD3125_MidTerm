package com.midtermmad3125.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.midtermmad3125.R;
import com.midtermmad3125.utils.ListWeather;

import java.util.List;

public class weatherAdapter extends ArrayAdapter<ListWeather> {

    public weatherAdapter(Context context, List<ListWeather> objects) {
        super(context, 0, objects);
    }



    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        // Get the data item for this position
        ListWeather u = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_weather, parent, false);
        }
        // Lookup view for data population
        TextView u1 = (TextView) convertView.findViewById(R.id.dt);
        TextView u2 = (TextView) convertView.findViewById(R.id.pressure);
        TextView u3 = (TextView) convertView.findViewById(R.id.humidity);
        TextView u4 = (TextView) convertView.findViewById(R.id.speed);
        // Populate the data into the template view using the data object
      //  u1.setText(u.getDt());
        u1.setText("spaceeeeee");
        u2.setText(u.getHumidity());
        u3.setText(u.getPressure());
        u4.setText(u.getSpeed());
        // Return the completed view to render on screen
        return convertView;

    }
}
