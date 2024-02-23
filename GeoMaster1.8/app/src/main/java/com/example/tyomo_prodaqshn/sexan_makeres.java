package com.example.tyomo_prodaqshn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class sexan_makeres extends AppCompatActivity {
    EditText sexan_makeres_patasxan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sexan_makeres);
       sexan_makeres_patasxan = findViewById(R.id.sexan_makeres_patasxan);
       sexan_makeres_patasxan.setOnClickListener(v -> {
            if(patasxaner.patasxan[9].equals(sexan_makeres_patasxan.getText().toString())){
                Toast.makeText(this, "Ответ правилен!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(sexan_makeres.this, sexan_start_patuhan.class);
                startActivity(intent);
            }else{
                Toast.makeText(this, "Ответ неправилен!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}