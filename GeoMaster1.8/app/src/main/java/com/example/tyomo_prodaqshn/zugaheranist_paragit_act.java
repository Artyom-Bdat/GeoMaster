package com.example.tyomo_prodaqshn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class zugaheranist_paragit_act extends AppCompatActivity {
    EditText zugaheranist_paragit_;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zugaheranist_paragit);
        zugaheranist_paragit_ = findViewById(R.id.zugaheranist_paragit_);
        zugaheranist_paragit_.setOnClickListener(v -> {
            if(patasxaner.patasxan[10].equals(zugaheranist_paragit_.getText().toString())){
                Toast.makeText(this, "Ответ правилен!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(zugaheranist_paragit_act.this, zugaheranist_start_patuhan.class);
                startActivity(intent);
            }else{
                Toast.makeText(this, "Ответ неправилен!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}