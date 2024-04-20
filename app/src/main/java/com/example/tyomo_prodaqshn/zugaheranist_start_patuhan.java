package com.example.tyomo_prodaqshn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class zugaheranist_start_patuhan extends AppCompatActivity {

    ImageView zugaheranist_paragit;
    ImageView zugaheranist_makeres;
    Button satrt_patuhan_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zugaheranist_start_patuhan);

       zugaheranist_paragit = findViewById(R.id.zugaheranist_paragit);
       zugaheranist_paragit.setOnClickListener(v -> {
            Intent intent = new Intent(zugaheranist_start_patuhan.this, zugaheranist_paragit_act.class);
            startActivity(intent);
           overridePendingTransition(0, 0);

        });

        zugaheranist_makeres = findViewById(R.id.zugaheranist_makeres);
        zugaheranist_makeres.setOnClickListener(v -> {
            Intent intent = new Intent(zugaheranist_start_patuhan.this, zugaheranist_makeres_act.class);
            startActivity(intent);
            overridePendingTransition(0, 0);

        });

        satrt_patuhan_button = findViewById(R.id.satrt_patuhan_button);
        satrt_patuhan_button.setOnClickListener(v -> {
            Intent intent = new Intent(zugaheranist_start_patuhan.this, start_patuhan.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
        });
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(zugaheranist_start_patuhan.this, start_patuhan.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

}