package com.example.tyomo_prodaqshn.east_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tyomo_prodaqshn.R;
import com.example.tyomo_prodaqshn.easy.very_easy;
import com.example.tyomo_prodaqshn.madium.madium;

import java.util.Random;

public class easy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_patuhan3);
    }


    public void nazad(View view) {
        Intent intent = new Intent(easy.this, very_easy.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(easy.this, very_easy.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
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
                intent = new Intent(easy.this, Leval_7.class);
                overridePendingTransition(0, 0);
                break;
            case 2:
                intent = new Intent(easy.this, Leval_8.class);
                overridePendingTransition(0, 0);
                break;
            case 3:
                intent = new Intent(easy.this, Leval_9.class);
                overridePendingTransition(0, 0);
                break;
            case 4:
                intent = new Intent(easy.this, Leval_10.class);
                overridePendingTransition(0, 0);
                break;
            case 5:
                intent = new Intent(easy.this, Leval_11.class);
                overridePendingTransition(0, 0);
                break;
            case 6:
                intent = new Intent(easy.this, Leval_12.class);
                overridePendingTransition(0, 0);
                break;
            default:
                // Handle unexpected case
                return;
        }

        // Запускаем уровень
        startActivity(intent);
    }

    public void dale(View view) {
        Intent intent = new Intent(easy.this, madium.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }
}