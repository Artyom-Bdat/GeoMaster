package com.example.tyomo_prodaqshn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class start_patuhan extends AppCompatActivity {

    ImageView qvadrat;
    ImageView klor;
    ImageView erankyun;
    ImageView sexan;
    ImageView zugaheranist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_patuhan);


        qvadrat = findViewById(R.id.qvadrat_qvadrat);
        qvadrat.setOnClickListener(v -> {
            Intent intent = new Intent(start_patuhan.this, qarankyun_1.class);
            startActivity(intent);
            overridePendingTransition(0, 0);

        });

        klor = findViewById(R.id.klor);
        klor.setOnClickListener(v -> {
            Intent intent = new Intent(start_patuhan.this, klor_diametr_radius.class);
            startActivity(intent);
            overridePendingTransition(0, 0);

        });

        erankyun = findViewById(R.id.erankyun);
        erankyun.setOnClickListener(v -> {
            Intent intent = new Intent(start_patuhan.this, erankyun_start_patuhan.class);
            startActivity(intent);
            overridePendingTransition(0, 0);

        });

        sexan = findViewById(R.id.sexan);
        sexan.setOnClickListener(v -> {
            Intent intent = new Intent(start_patuhan.this, sexan_start_patuhan.class);
            startActivity(intent);
            overridePendingTransition(0, 0);

        });

        zugaheranist = findViewById(R.id.zugaheranist);
        zugaheranist.setOnClickListener(v -> {
            Intent intent = new Intent(start_patuhan.this, zugaheranist_start_patuhan.class);
            startActivity(intent);
            overridePendingTransition(0, 0);

        });
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(start_patuhan.this, strat_vibor.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    public void Click(View view) {
        Intent intent = new Intent(start_patuhan.this, modelner3D.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    public void nazad(View view) {
        Intent intent = new Intent(start_patuhan.this, strat_vibor.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }


}