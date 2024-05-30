package com.example.tyomo_prodaqshn.madium;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.tyomo_prodaqshn.R;
import com.example.tyomo_prodaqshn.east_2.easy;
import com.example.tyomo_prodaqshn.hard.hard;
import com.example.tyomo_prodaqshn.strat_vibor;

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

        try {

            switch (randomLevel) {
                case 1:
                    intent = new Intent(madium.this, Leval_13.class);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                    break;
                case 2:
                    intent = new Intent(madium.this, Leval_14.class);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                    break;
                case 3:
                    intent = new Intent(madium.this, Leval_15.class);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                    break;
                case 4:
                    intent = new Intent(madium.this, Leval_16.class);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                    break;
                case 5:
                    intent = new Intent(madium.this, Leval_17.class);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                    break;
                case 6:
                    intent = new Intent(madium.this, Leval_18.class);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                    break;
                default:
                    // Handle unexpected case
                    return;


            }

            startActivity(intent);

        }catch (Exception e){
            Log.e("ERROR",e.getMessage());
        }

        // Запускаем уровень

    }

    public void nazad(View view) {
        Intent intent = new Intent(madium.this, easy.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(madium.this, easy.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
    public void dale(View view) {
        Intent intent = new Intent(madium.this, hard.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    public void kvibru(View view) {
        Intent intent = new Intent(madium.this, strat_vibor.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}