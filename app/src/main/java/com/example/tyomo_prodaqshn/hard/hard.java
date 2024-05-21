package com.example.tyomo_prodaqshn.hard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tyomo_prodaqshn.R;
import com.example.tyomo_prodaqshn.madium.Leval_13;
import com.example.tyomo_prodaqshn.madium.Leval_14;
import com.example.tyomo_prodaqshn.madium.Leval_15;
import com.example.tyomo_prodaqshn.madium.Leval_16;
import com.example.tyomo_prodaqshn.madium.Leval_17;
import com.example.tyomo_prodaqshn.madium.Leval_18;
import com.example.tyomo_prodaqshn.madium.madium;
import com.example.tyomo_prodaqshn.strat_vibor;


import java.util.Random;

public class hard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard);
    }
    public void nazad(View view) {
        Intent intent = new Intent(hard.this, madium.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(hard.this, madium.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }


    public void RandomLevel(View view) {
        // Создаем объект Random для генерации случайных чисел
        Random random = new Random();
        // Генерируем случайное число от 1 до 6
        int randomLevel = random.nextInt(6) + 1;

        // Создаем Intent для запуска соответствующего уровня
        Intent intent;
        switch (randomLevel) {
            case 1:
                intent = new Intent(hard.this, Leavl_19.class);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case 2:
                intent = new Intent(hard.this, Leval_20.class);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case 3:
                intent = new Intent(hard.this, Leval_21.class);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case 4:
                intent = new Intent(hard.this, Leval_22.class);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case 5:
                intent = new Intent(hard.this, Leval_23.class);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case 6:
                intent = new Intent(hard.this, Leval_24.class);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            default:
                // Handle unexpected case
                return;
        }

        // Запускаем уровень
        startActivity(intent);
    }

    public void kvibru(View view) {
        Intent intent = new Intent(hard.this, strat_vibor.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}