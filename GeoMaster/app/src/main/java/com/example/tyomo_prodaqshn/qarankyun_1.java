package com.example.tyomo_prodaqshn;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class qarankyun_1 extends AppCompatActivity {
    Button satrt_patuhan_button;
    ImageButton qarakusu_paragit;

    ImageButton qarakusu_makeres_2;
    ImageButton qarakusu_nerqnadziq;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qarankyun1);
        qarakusu_paragit= findViewById(R.id.qarakusu_paragit);
        satrt_patuhan_button = findViewById(R.id.satrt_patuhan_button);
        satrt_patuhan_button.setOnClickListener(v -> {
            Intent intent = new Intent(qarankyun_1.this, start_patuhan.class);
            startActivity(intent);
        });


        qarakusu_paragit.setOnClickListener(v -> {
            Intent intent = new Intent(qarankyun_1.this, Activity3.class);
            startActivity(intent);

        });
        qarakusu_makeres_2= findViewById(R.id.qarakusu_makeres_2);
        qarakusu_makeres_2.setOnClickListener(v -> {
            Intent intent = new Intent(qarankyun_1.this, qarankyun_Makeres

                    .class);
            startActivity(intent);

        });
        qarakusu_nerqnadziq= findViewById(R.id.qarakusu_nerqnadzigq);
        qarakusu_nerqnadziq.setOnClickListener(v -> {
            Intent intent = new Intent(qarankyun_1.this, qarankyun_nerqnadzigq.class);
            startActivity(intent);

        });


    }
}