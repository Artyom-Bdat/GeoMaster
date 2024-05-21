package com.example.tyomo_prodaqshn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class burg_makeres extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burg_makeres);
    }

    public void Paragit(View view) {
        Intent intent = new Intent(burg_makeres.this,   Burg_paragit.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    public void Makeres_koxmnayin(View view) {
        Intent intent = new Intent(burg_makeres.this,   Burg_Skoxmnayin.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(burg_makeres.this,modelner3D.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    public void Slriv(View view) {
        Intent intent = new Intent(burg_makeres.this,Burg_Slriv.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    public void nazad(View view) {
        Intent intent = new Intent(burg_makeres.this,modelner3D.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}