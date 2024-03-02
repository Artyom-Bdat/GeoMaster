package com.example.tyomo_prodaqshn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class erankyun_gradus_gumar extends AppCompatActivity {

    EditText pastxan_gradus_erk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erankyun_gradus_gumar);

        pastxan_gradus_erk = findViewById(R.id.patasxan_gradus_er);
        pastxan_gradus_erk.setOnClickListener(v -> {
            if(patasxaner.patasxan[12].equals(pastxan_gradus_erk.getText().toString())){
                Toast.makeText(this, "Ответ правилен!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(erankyun_gradus_gumar.this,erankyun_start_patuhan.class);
                startActivity(intent);
            }else{
                Toast.makeText(this, "Ответ неправилен!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}