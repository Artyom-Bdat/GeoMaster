package com.example.tyomo_prodaqshn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class erankyun_start_patuhan extends AppCompatActivity {
    Button satrt_patuhan_button;
    ImageView erankyun_paragit;
    ImageView erankyun_makeres;
    ImageView erankyun_gradus;
    ImageView erankyun_sinus;
    ImageView erankyun_cos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erankyun_start_patuhan);
        satrt_patuhan_button = findViewById(R.id.satrt_patuhan_button);
        satrt_patuhan_button.setOnClickListener(v -> {
            Intent intent = new Intent(erankyun_start_patuhan.this, start_patuhan.class);
            startActivity(intent);
        });

        erankyun_paragit= findViewById(R.id.erankyun_paragit);
        erankyun_paragit.setOnClickListener(v -> {
            Intent intent = new Intent(erankyun_start_patuhan.this, erankyun_paragit_act.class);
            startActivity(intent);
        });

        erankyun_makeres= findViewById(R.id.erankyun_makeres);
        erankyun_makeres.setOnClickListener(v -> {
            Intent intent = new Intent(erankyun_start_patuhan.this, erankyun_makeres_act.class);
            startActivity(intent);
        });

        erankyun_gradus= findViewById(R.id.erankyun_gradus);
        erankyun_gradus.setOnClickListener(v -> {
            Intent intent = new Intent(erankyun_start_patuhan.this, erankyun_gradus_gumar.class);
            startActivity(intent);
        });

        erankyun_sinus= findViewById(R.id.erankyun_sinus);
        erankyun_sinus.setOnClickListener(v -> {
            Intent intent = new Intent(erankyun_start_patuhan.this, erankyun_sinus.class);
            startActivity(intent);
        });

        erankyun_cos= findViewById(R.id.erankyun_cos);
        erankyun_cos.setOnClickListener(v -> {
            Intent intent = new Intent(erankyun_start_patuhan.this, erankyun_cos.class);
            startActivity(intent);
        });

    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(erankyun_start_patuhan.this, start_patuhan.class);
        startActivity(intent);
    }

}