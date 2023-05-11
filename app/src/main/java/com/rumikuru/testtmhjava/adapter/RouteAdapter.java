package com.rumikuru.testtmhjava.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.rumikuru.testtmhjava.R;
import com.rumikuru.testtmhjava.model.Route;

import java.util.List;

public class RouteAdapter extends ArrayAdapter<Route> {

    private Context context;
    private List<Route> routes;

    public RouteAdapter(Context context, List<Route> routes) {
        super(context, 0, routes);
        this.context = context;
        this.routes = routes;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Route route = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.route_item, parent, false);
        }

        // Lookup view for data population
        TextView routeName = convertView.findViewById(R.id.routeName);
        ListView stopList = convertView.findViewById(R.id.stopList);

        // Populate the data into the template view using the data object
        routeName.setText("Route " + (position+1));
        stopList.setAdapter(new StopAdapter(context, route.getStops()));

        // Return the completed view to render on screen
        return convertView;
    }
}
