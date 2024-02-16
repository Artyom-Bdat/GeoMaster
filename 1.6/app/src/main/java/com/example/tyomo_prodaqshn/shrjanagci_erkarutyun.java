package com.example.tyomo_prodaqshn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class shrjanagci_erkarutyun extends AppCompatActivity {

    EditText pastxan_klor_erkarutyun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shrjanagci_erkarutyun);
        pastxan_klor_erkarutyun = findViewById(R.id.patasxan_klor_erkarutyun);
        pastxan_klor_erkarutyun.setOnClickListener(v -> {
            if(patasxaner.patasxan[5].equals(pastxan_klor_erkarutyun.getText().toString())){
                Toast.makeText(this, "Ответ правилен!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(shrjanagci_erkarutyun.this, klor_diametr_radius.class);
                startActivity(intent);
            }else{
                Toast.makeText(this, "Ответ неправилен!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
