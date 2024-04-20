package com.example.tyomo_prodaqshn.madium;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tyomo_prodaqshn.R;
import com.example.tyomo_prodaqshn.east_2.easy;
import com.example.tyomo_prodaqshn.hard.hard;

import java.util.Random;

public class madium extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_madium);
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
                intent = new Intent(madium.this, Leval_13.class);
                overridePendingTransition(0, 0);
                break;
            case 2:
                intent = new Intent(madium.this, Leval_14.class);
                overridePendingTransition(0, 0);
                break;
            case 3:
                intent = new Intent(madium.this, Leval_15.class);
                overridePendingTransition(0, 0);
                break;
            case 4:
                intent = new Intent(madium.this, Leval_16.class);
                overridePendingTransition(0, 0);
                break;
            case 5:
                intent = new Intent(madium.this, Leval_17.class);
                overridePendingTransition(0, 0);
                break;
            case 6:
                intent = new Intent(madium.this, Leval_18.class);
                overridePendingTransition(0, 0);
                break;
            default:
                // Handle unexpected case
                return;
        }

        // Запускаем уровень
        startActivity(intent);
    }

    public void nazad(View view) {
        Intent intent = new Intent(madium.this, easy.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(madium.this, easy.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }
    public void dale(View view) {
        Intent intent = new Intent(madium.this, hard.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }
}