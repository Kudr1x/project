package com.example.project.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.project.R;

public class allTrips extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_trips);

        Intent i = getIntent();

        i.getStringExtra("flag");
        
        boolean flag = i.getBooleanExtra("flag", true);
        
        
        if(flag){
            Toast.makeText(this, "Все маршруты для попутчика", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Все запросы попутчиков", Toast.LENGTH_SHORT).show();
        }

    }
}