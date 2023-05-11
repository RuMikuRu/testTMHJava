package com.rumikuru.testtmhjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.rumikuru.testtmhjava.adapter.RouteAdapter;
import com.rumikuru.testtmhjava.model.Route;
import com.rumikuru.testtmhjava.model.Stop;

import java.util.ArrayList;
import java.util.List;

public class ListRoute extends AppCompatActivity {
    private ListView routeList;
    private List<Route> routes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_route);

        // Create some sample data
        routes = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Route route = new Route();
            List<Stop> stops = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                Stop stop = new Stop();
                stop.setPlace("Stop " + (j+1));
                stop.setDepartureTime("10:00 AM");
                stop.setArrivalTime("11:00 AM");
                stops.add(stop);
                stops.add(stop);
            }
            route.setStops(stops);
            routes.add(route);
        }

        // Set up the ListView with the custom adapter
        routeList = findViewById(R.id.routeList);
        routeList.setAdapter(new RouteAdapter(this, routes));
    }
}