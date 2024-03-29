package com.example.tyomo_prodaqshn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class start_patuhan_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_patuhan3);
    }


    public void nazad(View view) {
        Intent intent = new Intent(start_patuhan_3.this, start_patuhan_2.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(start_patuhan_3.this, start_patuhan_2.class);
        startActivity(intent);
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
                intent = new Intent(start_patuhan_3.this, Leval_7.class);
                break;
            case 2:
                intent = new Intent(start_patuhan_3.this, Leval_8.class);
                break;
            case 3:
                intent = new Intent(start_patuhan_3.this, Leval_9.class);
                break;
            case 4:
                intent = new Intent(start_patuhan_3.this, Leval_10.class);
                break;
            case 5:
                intent = new Intent(start_patuhan_3.this, Leval_11.class);
                break;
            case 6:
                intent = new Intent(start_patuhan_3.this, Leval_12.class);
                break;
            default:
                // Handle unexpected case
                return;
        }

        // Запускаем уровень
        startActivity(intent);
    }
}