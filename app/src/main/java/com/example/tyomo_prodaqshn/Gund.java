package com.example.tyomo_prodaqshn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Gund extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gund);
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(Gund.this,modelner3D.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    public void nazad(View view) {
        Intent intent = new Intent(Gund.this,modelner3D.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    public void Gund(View view) {
        Intent intent = new Intent(Gund.this,modelner3D.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }
}