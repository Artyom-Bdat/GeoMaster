package com.example.tyomo_prodaqshn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class start_patuhan_2 extends AppCompatActivity {

    Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_patuhan2);

        home = findViewById(R.id.home);
        home.setOnClickListener(v -> {
            Intent intent = new Intent(start_patuhan_2.this, strat_vibor.class);
            startActivity(intent);
        });

    }

    public void Level_1(View view) {
        Intent intent = new Intent(start_patuhan_2.this, Leval_1.class);
        startActivity(intent);
    }

    public void Level_2(View view) {
        Intent intent = new Intent(start_patuhan_2.this, Leval_2.class);
        startActivity(intent);
    }

    public void Level_3(View view) {
        Intent intent = new Intent(start_patuhan_2.this, Leval_3.class);
        startActivity(intent);
    }

    public void Level_4(View view) {
        Intent intent = new Intent(start_patuhan_2.this, Leval_4.class);
        startActivity(intent);
    }

    public void Level_5(View view) {
        Intent intent = new Intent(start_patuhan_2.this, Leval_5.class);
        startActivity(intent);
    }

    public void Level_6(View view) {
        Intent intent = new Intent(start_patuhan_2.this, Leval_6.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(start_patuhan_2.this, strat_vibor.class);
        startActivity(intent);
    }
}