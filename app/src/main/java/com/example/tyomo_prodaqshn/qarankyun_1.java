package com.example.tyomo_prodaqshn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class qarankyun_1 extends AppCompatActivity {
    Button satrt_patuhan_button;
    ImageView qarakusu_paragit;

    ImageView qarakusu_makeres_2;
    ImageView qarakusu_nerqnadziq;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qarankyun1);
        qarakusu_paragit= findViewById(R.id.qarakusu_paragit);
        satrt_patuhan_button = findViewById(R.id.satrt_patuhan_button);
        satrt_patuhan_button.setOnClickListener(v -> {
            Intent intent = new Intent(qarankyun_1.this, start_patuhan.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
        });


        qarakusu_paragit.setOnClickListener(v -> {
            Intent intent = new Intent(qarankyun_1.this, Activity3.class);
            startActivity(intent);
            overridePendingTransition(0, 0);

        });
        qarakusu_makeres_2= findViewById(R.id.qarakusu_makeres_2);
        qarakusu_makeres_2.setOnClickListener(v -> {
            Intent intent = new Intent(qarankyun_1.this, qarankyun_Makeres

                    .class);
            startActivity(intent);
            overridePendingTransition(0, 0);

        });
        qarakusu_nerqnadziq= findViewById(R.id.qarakusu_nerqnadzig);
        qarakusu_nerqnadziq.setOnClickListener(v -> {
            Intent intent = new Intent(qarankyun_1.this, qarankyun_nerqnadzigq.class);
            startActivity(intent);
            overridePendingTransition(0, 0);

        });
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(qarankyun_1.this, start_patuhan.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

}