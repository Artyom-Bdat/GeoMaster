package com.example.tyomo_prodaqshn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class qarankyun_1 extends AppCompatActivity {

    ImageView qarakusu_paragit;

    ImageView qarakusu_makeres_2;
    ImageView qarakusu_nerqnadziq;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qarankyun1);
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(qarankyun_1.this, start_patuhan.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    public void nazad(View view) {
        Intent intent = new Intent(qarankyun_1.this, start_patuhan.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    public void Q_P(View view) {
        Intent intent = new Intent(qarankyun_1.this, Activity3.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    public void Q_M(View view) {
        Intent intent = new Intent(qarankyun_1.this, qarankyun_Makeres

                .class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    public void Q_N(View view) {
        Intent intent = new Intent(qarankyun_1.this, qarankyun_nerqnadzigq.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }
}