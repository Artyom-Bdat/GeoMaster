package com.example.tyomo_prodaqshn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import www.sanju.motiontoast.MotionToast;
import www.sanju.motiontoast.MotionToastStyle;

public class qarankyun_nerqnadzigq extends AppCompatActivity {
    EditText pastxan_nerqnadziq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qarankyun_nerqnadzigq);
        pastxan_nerqnadziq = findViewById(R.id.patasxan_dioganal);
        pastxan_nerqnadziq.setOnClickListener(v -> {
            if(patasxaner.patasxan[2].equals(pastxan_nerqnadziq.getText().toString())){
                MotionToast.Companion.createColorToast(this,
                        "Ответ правелен!",
                        "Молодец!",
                        MotionToastStyle.SUCCESS,
                        MotionToast.GRAVITY_BOTTOM,
                        MotionToast.LONG_DURATION,
                        ResourcesCompat.getFont(this, www.sanju.motiontoast.R.font.helveticabold));
                Intent intent = new Intent(qarankyun_nerqnadzigq.this,qarankyun_1.class);
                startActivity(intent);
                MainActivity.bal ++;
            }else{
                MotionToast.Companion.createColorToast(this,
                        "Ответ неправильный!",
                        "подумай еще",
                        MotionToastStyle.ERROR,
                        MotionToast.GRAVITY_BOTTOM,
                        MotionToast.LONG_DURATION,
                        ResourcesCompat.getFont(this, www.sanju.motiontoast.R.font.helveticabold));
            }
        });
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(qarankyun_nerqnadzigq.this,qarankyun_1.class);
        startActivity(intent);
    }

    public void Click(View view) {
        MediaPlayer mediaPlayer = MediaPlayer.create(qarankyun_nerqnadzigq.this, R.raw.qarakusu_nerqnadziq);
        mediaPlayer.start();

        view.setEnabled(false);
        ((ImageView)view).setImageResource(R.drawable.miqrafon_on);

        new CountDownTimer(10000, 1000) {
            public void onTick(long millisUntilFinished) {
                // Здесь можно добавить обновление интерфейса, например, отображение оставшегося времени
            }

            public void onFinish() {
                // По завершению таймера, восстанавливаем доступ к кнопке микрофона
                view.setEnabled(true);
                ((ImageView)view).setImageResource(R.drawable.miqrafon_off);
            }
        }.start();
    }
}