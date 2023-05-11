package com.rumikuru.testtmhjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.rumikuru.testtmhjava.model.Route;
import com.rumikuru.testtmhjava.model.Stop;

import java.io.IOException;

public class CreateRoutes extends AppCompatActivity {
    private int count = 0;
    private LinearLayout layout;
    private Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_routes);


        layout = findViewById(R.id.layout);
        saveBtn = findViewById(R.id.saveBtn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    saveRoute();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private void addNewFields() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        EditText placeEditText = new EditText(this);
        placeEditText.setHint("Название пункта");
        layout.addView(placeEditText, params);

        EditText departureEditText = new EditText(this);
        departureEditText.setHint("Время отбытия");
        layout.addView(departureEditText, params);

        EditText arrivalEditText = new EditText(this);
        arrivalEditText.setHint("Время прибытия");
        layout.addView(arrivalEditText, params);

        //route.addStop(new Stop(
        //      placeEditText.getText().toString(),
        //    departureEditText.getText().toString(),
        //  arrivalEditText.getText().toString()
        // ));

    }

    private void saveRoute() throws IOException {
        this.count++;
        Route route = new Route();
        System.out.println(layout.getChildCount());
        for (int i = 0; i < layout.getChildCount(); i += 3) {
            EditText placeEditText = (EditText) layout.getChildAt(i);
            EditText departureEditText = (EditText) layout.getChildAt(i + 1);
            EditText arrivalEditText = (EditText) layout.getChildAt(i + 2);
            Stop stop = new Stop(
                    placeEditText.getText().toString().trim(),
                    departureEditText.getText().toString().trim(),
                    arrivalEditText.getText().toString().trim()
            );
            route.addStop(stop);
        }

        // Save the route to a database or file
        // ...
        Gson gson = new Gson();
        String routeGson = gson.toJson(route);
        String id = "" + count;
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(CreateRoutes.this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(id,routeGson);
        editor.commit();
        // Clear the layout and route object for creating a new route
        layout.removeAllViews();
    }

    public void onAddFieldsClick(View view) {
        addNewFields();
    }
}
