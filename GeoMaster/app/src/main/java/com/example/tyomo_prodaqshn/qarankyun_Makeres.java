package com.example.tyomo_prodaqshn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class qarankyun_Makeres extends AppCompatActivity {
    EditText pastxan_makeres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qarankyun_makeres);
        pastxan_makeres = findViewById(R.id.patasxan_Makeres);
        pastxan_makeres.setOnClickListener(v -> {
            if(patasxaner.patasxan[1].equals(pastxan_makeres.getText().toString())){
                Toast.makeText(this, "Ответ правилен!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(qarankyun_Makeres.this,qarankyun_1.class);
                startActivity(intent);
            }else{
                Toast.makeText(this, "Ответ неправилен!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}