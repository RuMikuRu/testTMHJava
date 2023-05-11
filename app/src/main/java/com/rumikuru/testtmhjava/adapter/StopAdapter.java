package com.rumikuru.testtmhjava.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.rumikuru.testtmhjava.R;
import com.rumikuru.testtmhjava.model.Stop;

import java.util.List;

public class StopAdapter extends ArrayAdapter<Stop> {

    private Context context;
    private List<Stop> stops;

    public StopAdapter(Context context, List<Stop> stops) {
        super(context, 0, stops);
        this.context = context;
        this.stops = stops;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        stops = (List<Stop>) getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.stop_item, parent, false);
        }
        for(int i=0;i< stops.size();i++){

        }
        // Lookup view for data population
        TextView placeName = convertView.findViewById(R.id.placeName);
        TextView departureTime = convertView.findViewById(R.id.departureTime);
        TextView arrivalTime = convertView.findViewById(R.id.arrivalTime);

        // Populate the data into the template view using the data object
        placeName.setText(stops.getPlace());
        departureTime.setText("Departure: " + stop.getDepartureTime());
        arrivalTime.setText("Arrival: " + stop.getArrivalTime());

        // Return the completed view to render on screen
        return convertView;
    }
}
