package com.example.tyomo_prodaqshn.easy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tyomo_prodaqshn.R;
import com.example.tyomo_prodaqshn.east_2.easy;
import com.example.tyomo_prodaqshn.strat_vibor;

import java.util.Random;

public class very_easy extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_patuhan2);


    }

    public void startRandomLevel(View view) {
        // Создаем объект Random для генерации случайных чисел
        Random random = new Random();
        // Генерируем случайное число от 1 до 6
        int randomLevel = random.nextInt(6) + 1;

        // Создаем Intent для запуска соответствующего уровня
        Intent intent;
        switch (randomLevel) {
            case 1:
                intent = new Intent(very_easy.this, Leval_1.class);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case 2:
                intent = new Intent(very_easy.this, Leval_2.class);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case 3:
                intent = new Intent(very_easy.this, Leval_3.class);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case 4:
                intent = new Intent(very_easy.this, Leval_4.class);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case 5:
                intent = new Intent(very_easy.this, Leval_5.class);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case 6:
                intent = new Intent(very_easy.this, Leval_6.class);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            default:
                // Handle unexpected case
                return;
        }

        // Запускаем уровень
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(very_easy.this, strat_vibor.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    public void kvibru(View view) {
        Intent intent = new Intent(very_easy.this, strat_vibor.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    public void dale(View view) {
        Intent intent = new Intent(very_easy.this, easy.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);;
    }
}