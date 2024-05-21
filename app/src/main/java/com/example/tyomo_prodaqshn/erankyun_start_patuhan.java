package com.example.tyomo_prodaqshn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class erankyun_start_patuhan extends AppCompatActivity {

    ImageView erankyun_paragit;
    ImageView erankyun_makeres;
    ImageView erankyun_gradus;
    ImageView erankyun_sinus;
    ImageView erankyun_cos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erankyun_start_patuhan);


        erankyun_paragit= findViewById(R.id.erankyun_paragit);
        erankyun_paragit.setOnClickListener(v -> {
            Intent intent = new Intent(erankyun_start_patuhan.this, erankyun_paragit_act.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });

        erankyun_makeres= findViewById(R.id.erankyun_makeres);
        erankyun_makeres.setOnClickListener(v -> {
            Intent intent = new Intent(erankyun_start_patuhan.this, erankyun_makeres_act.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });

        erankyun_gradus= findViewById(R.id.erankyun_gradus);
        erankyun_gradus.setOnClickListener(v -> {
            Intent intent = new Intent(erankyun_start_patuhan.this, erankyun_gradus_gumar.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });

        erankyun_sinus= findViewById(R.id.erankyun_sinus);
        erankyun_sinus.setOnClickListener(v -> {
            Intent intent = new Intent(erankyun_start_patuhan.this, com.example.tyomo_prodaqshn.erankyun_sinus.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });

        erankyun_cos= findViewById(R.id.erankyun_cos);
        erankyun_cos.setOnClickListener(v -> {
            Intent intent = new Intent(erankyun_start_patuhan.this, com.example.tyomo_prodaqshn.erankyun_cos.class);
            startActivity(intent);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        });

    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(erankyun_start_patuhan.this, start_patuhan.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }


    public void nazad(View view) {
        Intent intent = new Intent(erankyun_start_patuhan.this, start_patuhan.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}