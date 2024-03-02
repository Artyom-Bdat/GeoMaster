package com.example.tyomo_prodaqshn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class zugaheranist_makeres_act extends AppCompatActivity {
    EditText patasxan_zugaheranist_makeres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zugaheranist_makeres);
        patasxan_zugaheranist_makeres = findViewById(R.id.patasxan_zugaheranist_makeres);
        patasxan_zugaheranist_makeres.setOnClickListener(v -> {
            if(patasxaner.patasxan[11].equals(patasxan_zugaheranist_makeres.getText().toString())){
                Toast.makeText(this, "Ответ правилен!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(zugaheranist_makeres_act.this,zugaheranist_start_patuhan.class);
                startActivity(intent);
            }else{
                Toast.makeText(this, "Ответ неправилен!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}