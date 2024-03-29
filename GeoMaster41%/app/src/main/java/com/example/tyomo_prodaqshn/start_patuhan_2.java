package com.example.tyomo_prodaqshn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class start_patuhan_2 extends AppCompatActivity {

    Button dale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_patuhan2);


        dale= findViewById(R.id.dale);
        dale.setOnClickListener(v -> {
            Intent intent = new Intent(start_patuhan_2.this, start_patuhan_3.class);
            startActivity(intent);

        });

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
                intent = new Intent(start_patuhan_2.this, Leval_1.class);
                break;
            case 2:
                intent = new Intent(start_patuhan_2.this, Leval_2.class);
                break;
            case 3:
                intent = new Intent(start_patuhan_2.this, Leval_3.class);
                break;
            case 4:
                intent = new Intent(start_patuhan_2.this, Leval_4.class);
                break;
            case 5:
                intent = new Intent(start_patuhan_2.this, Leval_5.class);
                break;
            case 6:
                intent = new Intent(start_patuhan_2.this, Leval_6.class);
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
        Intent intent = new Intent(start_patuhan_2.this, strat_vibor.class);
        startActivity(intent);
    }

    public void kvibru(View view) {
        Intent intent = new Intent(start_patuhan_2.this, strat_vibor.class);
        startActivity(intent);
    }

}