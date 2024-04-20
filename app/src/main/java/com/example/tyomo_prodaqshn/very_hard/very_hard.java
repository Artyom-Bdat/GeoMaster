package com.example.tyomo_prodaqshn.very_hard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tyomo_prodaqshn.R;
import com.example.tyomo_prodaqshn.hard.hard;
import com.example.tyomo_prodaqshn.madium.madium;

public class very_hard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_very_hard);
    }
    public void nazad(View view) {
        Intent intent = new Intent(very_hard.this, hard.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(very_hard.this, hard.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }
}