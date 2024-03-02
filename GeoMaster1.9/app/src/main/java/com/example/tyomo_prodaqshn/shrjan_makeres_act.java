package com.example.tyomo_prodaqshn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class shrjan_makeres_act extends AppCompatActivity {

    EditText pastxan_makeres_klor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shrjan_makeres);

        pastxan_makeres_klor = findViewById(R.id.patasxan_Makeres_klor);
        pastxan_makeres_klor.setOnClickListener(v -> {
            if(patasxaner.patasxan[4].equals(pastxan_makeres_klor.getText().toString())){
                Toast.makeText(this, "Ответ правилен!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(shrjan_makeres_act.this, klor_diametr_radius.class);
                startActivity(intent);
            }else{
                Toast.makeText(this, "Ответ неправилен!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}