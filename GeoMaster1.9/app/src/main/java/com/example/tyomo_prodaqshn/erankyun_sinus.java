package com.example.tyomo_prodaqshn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class erankyun_sinus extends AppCompatActivity {

    EditText patasxan_sinus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erankyun_sinus);
        patasxan_sinus = findViewById(R.id.patasxan_sinus);
        patasxan_sinus.setOnClickListener(v -> {
            if(patasxaner.patasxan[13].equals(patasxan_sinus.getText().toString())){
                Toast.makeText(this, "Ответ правилен!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(erankyun_sinus.this,erankyun_start_patuhan.class);
                startActivity(intent);
            }else{
                Toast.makeText(this, "Ответ неправилен!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}