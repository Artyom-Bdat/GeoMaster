package com.example.tyomo_prodaqshn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class diametr_radius_act extends AppCompatActivity {

    EditText pastxan_radius;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diametr_radius);


        EditText patasxan_radius;

        pastxan_radius = findViewById(R.id.patasxan_radius);
        pastxan_radius.setOnClickListener(v -> {
            if(patasxaner.patasxan[3].equals(pastxan_radius.getText().toString())){
                Toast.makeText(this, "Ответ правилен!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(diametr_radius_act.this, klor_diametr_radius.class);
                startActivity(intent);
            }else{
                Toast.makeText(this, "Ответ неправилен!", Toast.LENGTH_SHORT).show();
            }
        });



    }


}