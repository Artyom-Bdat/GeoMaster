package com.example.tyomo_prodaqshn;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class start_patuhan extends AppCompatActivity {
    Button home;
    ImageButton qvadrat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_patuhan);
        home = findViewById(R.id.home);
        home.setOnClickListener(v -> {
            Intent intent = new Intent(start_patuhan.this, MainActivity.class);
            startActivity(intent);
        });



        qvadrat = findViewById(R.id.qvadrat_qvadrat);
        qvadrat.setOnClickListener(v -> {
            Intent intent = new Intent(start_patuhan.this, qarankyun_1.class);
            startActivity(intent);

        });


    }
}