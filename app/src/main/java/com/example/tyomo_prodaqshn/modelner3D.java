package com.example.tyomo_prodaqshn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class modelner3D extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modelner3_d);
    }

    public void Burg(View view) {
        Intent intent = new Intent(modelner3D.this, burg_makeres.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(modelner3D.this,start_patuhan.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    public void nazad(View view) {
        Intent intent = new Intent(modelner3D.this,start_patuhan.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    public void zugaheranist(View view) {
        Intent intent = new Intent(modelner3D.this,Zugaheranist_m3.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    public void gund(View view) {
        Intent intent = new Intent(modelner3D.this,Gund.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }
}