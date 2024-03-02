package com.example.tyomo_prodaqshn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class klor_sektor extends AppCompatActivity {

    EditText klor_patasxan_sektor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klor_sektor);

        klor_patasxan_sektor = findViewById(R.id.klor_patasxan_sektor);
        klor_patasxan_sektor.setOnClickListener(v -> {
            if(patasxaner.patasxan[15].equals(klor_patasxan_sektor.getText().toString())){
                Toast.makeText(this, "Ответ правилен!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(klor_sektor.this, klor_diametr_radius.class);
                startActivity(intent);
            }else{
                Toast.makeText(this, "Ответ неправилен!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}