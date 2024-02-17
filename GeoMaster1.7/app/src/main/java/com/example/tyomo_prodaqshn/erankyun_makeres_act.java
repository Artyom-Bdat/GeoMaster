package com.example.tyomo_prodaqshn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class erankyun_makeres_act extends AppCompatActivity {
    EditText pastxan_erankyun_makeres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erankyun_makeres);
        pastxan_erankyun_makeres = findViewById(R.id.patasxan_erankyun_makeres);
        pastxan_erankyun_makeres.setOnClickListener(v -> {
            if(patasxaner.patasxan[7].equals(pastxan_erankyun_makeres.getText().toString())){
                Toast.makeText(this, "Ответ правилен!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(erankyun_makeres_act.this, erankyun_start_patuhan.class);
                startActivity(intent);
            }else{
                Toast.makeText(this, "Ответ неправилен!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}