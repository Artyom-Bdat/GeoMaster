package com.example.tyomo_prodaqshn;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {
    EditText pastxan_inpat;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        patasxaner patasxaner = new patasxaner();
        setContentView(R.layout.activity_3);
       pastxan_inpat = findViewById(R.id.patasxan_inpat);
       pastxan_inpat.setOnClickListener(v -> {
           if(patasxaner.patasxan[0].equals(pastxan_inpat.getText().toString())){
               Toast.makeText(this, "Ответ правилен!", Toast.LENGTH_SHORT).show();
               Intent intent = new Intent(Activity3.this,start_patuhan.class);
               startActivity(intent);
           }else{
               Toast.makeText(this, "Ответ неправилен!", Toast.LENGTH_SHORT).show();
           }
       });


    }
}