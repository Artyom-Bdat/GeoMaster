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
import com.example.tyomo_prodaqshn.very_hard.very_hard;

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
        overridePendingTransition(0, 0);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(hard.this, madium.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }
    public void dale(View view) {
        Intent intent = new Intent(hard.this, very_hard.class);
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
                intent = new Intent(hard.this, Leavl_19.class);
                overridePendingTransition(0, 0);
                break;
            case 2:
                intent = new Intent(hard.this, Leval_20.class);
                overridePendingTransition(0, 0);
                break;
            case 3:
                intent = new Intent(hard.this, Leval_21.class);
                overridePendingTransition(0, 0);
                break;
            case 4:
                intent = new Intent(hard.this, Leval_22.class);
                overridePendingTransition(0, 0);
                break;
            case 5:
                intent = new Intent(hard.this, Leval_23.class);
                overridePendingTransition(0, 0);
                break;
            case 6:
                intent = new Intent(hard.this, Leval_24.class);
                overridePendingTransition(0, 0);
                break;
            default:
                // Handle unexpected case
                return;
        }

        // Запускаем уровень
        startActivity(intent);
    }
}