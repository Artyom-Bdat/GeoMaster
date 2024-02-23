package com.example.tyomo_prodaqshn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class sexan_paragit_act extends AppCompatActivity {
    EditText pastxan_sexan_paragit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sexan_paragit);
        pastxan_sexan_paragit = findViewById(R.id.patasxan_sexan_paragit);
        pastxan_sexan_paragit.setOnClickListener(v -> {
            if(patasxaner.patasxan[8].equals(pastxan_sexan_paragit.getText().toString())){
                Toast.makeText(this, "Ответ правилен!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(sexan_paragit_act.this, sexan_start_patuhan.class);
                startActivity(intent);
            }else{
                Toast.makeText(this, "Ответ неправилен!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}