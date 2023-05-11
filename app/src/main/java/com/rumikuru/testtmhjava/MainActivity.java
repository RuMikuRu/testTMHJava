package com.rumikuru.testtmhjava;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.rumikuru.testtmhjava.model.Route;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonCreateRoute = findViewById(R.id.create_route_button);
        buttonCreateRoute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Создадим Intent для перехода на новую Activity
                Intent intent = new Intent(MainActivity.this, CreateRoutes.class);

                // Запустим новую Activity
                startActivity(intent);
            }
        });
         Button buttonListRoute = findViewById(R.id.list_route_button);
         buttonListRoute.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(MainActivity.this, ListRoute.class);
                 startActivity(intent);
             }
         });
    }
}