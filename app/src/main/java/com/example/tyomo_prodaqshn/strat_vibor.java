package com.example.tyomo_prodaqshn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tyomo_prodaqshn.easy.very_easy;

public class strat_vibor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strat_vibor);
    }

    public void Click(View view) {
        Intent intent = new Intent(strat_vibor.this, start_patuhan.class);
        startActivity(intent);
    }

    public void onBackPressed(){
        Intent intent = new Intent(strat_vibor.this, MainActivity.class);
        startActivity(intent);
    }

    public void Click_up(View view) {
        Intent intent = new Intent(strat_vibor.this, very_easy.class);
        startActivity(intent);
    }
}