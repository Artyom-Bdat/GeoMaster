package com.example.tyomo_prodaqshn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class sexan_start_patuhan extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sexan_start_patuhan);

    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(sexan_start_patuhan.this, start_patuhan.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    public void S_P(View view) {
        Intent intent = new Intent(sexan_start_patuhan.this, sexan_paragit_act.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    public void S_S(View view) {
        Intent intent = new Intent(sexan_start_patuhan.this, com.example.tyomo_prodaqshn.sexan_makeres.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    public void nazad(View view) {
        Intent intent = new Intent(sexan_start_patuhan.this, start_patuhan.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }
}