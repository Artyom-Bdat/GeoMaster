package com.example.tyomo_prodaqshn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class erankyun_paragit_act extends AppCompatActivity {
    EditText pastxan_erankyun_paragit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erankyun_paragit);
        pastxan_erankyun_paragit = findViewById(R.id.patasxan_erankyun_paragit_);
        pastxan_erankyun_paragit.setOnClickListener(v -> {
            if(patasxaner.patasxan[6].equals(pastxan_erankyun_paragit.getText().toString())){
                Toast.makeText(this, "Ответ правилен!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(erankyun_paragit_act.this, erankyun_start_patuhan.class);
                startActivity(intent);
            }else{
                Toast.makeText(this, "Ответ неправилен!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}