package com.example.tyomo_prodaqshn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class sexan_start_patuhan extends AppCompatActivity {

    Button satrt_patuhan_button;
    ImageView sexan_paragit;
    ImageView sexan_makeres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sexan_start_patuhan);


        satrt_patuhan_button = findViewById(R.id.satrt_patuhan_button);
        satrt_patuhan_button.setOnClickListener(v -> {
            Intent intent = new Intent(sexan_start_patuhan.this, start_patuhan.class);
            startActivity(intent);
        });

       sexan_paragit= findViewById(R.id.sexan_paragit);
       sexan_paragit.setOnClickListener(v -> {
            Intent intent = new Intent(sexan_start_patuhan.this, sexan_paragit_act.class);
            startActivity(intent);

        });

        sexan_makeres= findViewById(R.id.sexan_makeres);
        sexan_makeres.setOnClickListener(v -> {
            Intent intent = new Intent(sexan_start_patuhan.this, com.example.tyomo_prodaqshn.sexan_makeres.class);
            startActivity(intent);

        });


    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(sexan_start_patuhan.this, start_patuhan.class);
        startActivity(intent);
    }

}