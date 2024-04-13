package com.example.tyomo_prodaqshn.hard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tyomo_prodaqshn.R;
import com.example.tyomo_prodaqshn.madium.madium;
import com.example.tyomo_prodaqshn.very_hard.very_hard;

public class hard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard);
    }
    public void nazad(View view) {
        Intent intent = new Intent(hard.this, madium.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(hard.this, madium.class);
        startActivity(intent);
    }
    public void dale(View view) {
        Intent intent = new Intent(hard.this, very_hard.class);
        startActivity(intent);
    }
}