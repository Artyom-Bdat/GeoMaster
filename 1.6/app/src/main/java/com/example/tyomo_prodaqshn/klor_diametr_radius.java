package com.example.tyomo_prodaqshn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class klor_diametr_radius extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klor_diametr_radius);

        View satrt_patuhan_button = findViewById(R.id.satrt_patuhan_button);
        satrt_patuhan_button.setOnClickListener(v -> {
            Intent intent = new Intent(klor_diametr_radius.this, start_patuhan.class);
            startActivity(intent);
        });

        ImageButton Klor_radius;
        Klor_radius = findViewById(R.id.klor_radiust);
        Klor_radius.setOnClickListener(v -> {
            Intent intent = new Intent(klor_diametr_radius.this, diametr_radius_act.class);
            startActivity(intent);
        });


        ImageButton Klor_makeres;
        Klor_makeres = findViewById(R.id.klor_maakeres);
        Klor_makeres.setOnClickListener(v -> {
            Intent intent = new Intent(klor_diametr_radius.this, shrjan_makeres_act.class);
            startActivity(intent);
        });

        ImageButton Klor_erkarutyun;
        Klor_erkarutyun = findViewById(R.id.klor_erkarutyun);
        Klor_erkarutyun.setOnClickListener(v -> {
            Intent intent = new Intent(klor_diametr_radius.this, shrjanagci_erkarutyun.class);
            startActivity(intent);
        });

    }
}