package com.example.tyomo_prodaqshn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class erankyun_cos extends AppCompatActivity {

    EditText erankyun_cos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erankyun_cos);

        erankyun_cos = findViewById(R.id.eranakyun_cos_);
        erankyun_cos.setOnClickListener(v -> {
            if(patasxaner.patasxan[14].equals(erankyun_cos.getText().toString())){
                Toast.makeText(this, "Ответ правилен!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(erankyun_cos.this,erankyun_start_patuhan.class);
                startActivity(intent);
            }else{
                Toast.makeText(this, "Ответ неправилен!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}