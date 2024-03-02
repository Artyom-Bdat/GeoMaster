package com.example.tyomo_prodaqshn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class klor_sigment extends AppCompatActivity {
    EditText patasxan_klor_sigment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klor_sigment);

        patasxan_klor_sigment = findViewById(R.id.patasxan_klor_sigment);
        patasxan_klor_sigment.setOnClickListener(v -> {
            if(patasxaner.patasxan[15].equals(patasxan_klor_sigment.getText().toString())){
                Toast.makeText(this, "Ответ правилен!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(klor_sigment.this, klor_diametr_radius.class);
                startActivity(intent);
            }else{
                Toast.makeText(this, "Ответ неправилен!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}