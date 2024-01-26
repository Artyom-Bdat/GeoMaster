package com.example.tyomo_prodaqshn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class qarankyun_nerqnadzigq extends AppCompatActivity {
    EditText pastxan_nerqnadziq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qarankyun_nerqnadzigq);
        pastxan_nerqnadziq = findViewById(R.id.patasxan_dioganal);
        pastxan_nerqnadziq.setOnClickListener(v -> {
            if(patasxaner.patasxan[2].equals(pastxan_nerqnadziq.getText().toString())){
                Toast.makeText(this, "Ответ правилен!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(qarankyun_nerqnadzigq.this,qarankyun_1.class);
                startActivity(intent);
            }else{
                Toast.makeText(this, "Ответ неправилен!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}