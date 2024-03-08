package com.example.tyomo_prodaqshn;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AutomaticZenRule;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import okhttp3.internal.http2.Header;
import www.sanju.motiontoast.MotionToast;
import www.sanju.motiontoast.MotionToastStyle;

public class Activity3 extends AppCompatActivity {
    EditText pastxan_inpat;

    Long timeoutSeconds = 24L;

    ImageView microfon;

    MediaPlayer microfonSaund;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
       pastxan_inpat = findViewById(R.id.patasxan_inpat);
       pastxan_inpat.setOnClickListener(v -> {
           if(patasxaner.patasxan[0].equals(pastxan_inpat.getText().toString())){
               MotionToast.Companion.createToast(Activity3.this,
                       "Моладец!",
                       "Ответ правилен.",
                       MotionToastStyle.SUCCESS,
                       MotionToast.GRAVITY_BOTTOM,
                       MotionToast.LONG_DURATION,
                       ResourcesCompat.getFont(Activity3.this, www.sanju.motiontoast.R.font.helveticabold));
               Intent intent = new Intent(Activity3.this,qarankyun_1.class);
               startActivity(intent);
           }else{
               MotionToast.Companion.createToast(this,
                       "Неправильно!",
                       "Подумай еще!",
                       MotionToastStyle.ERROR,
                       MotionToast.GRAVITY_BOTTOM,
                       MotionToast.LONG_DURATION,
                       ResourcesCompat.getFont(this, www.sanju.motiontoast.R.font.helveticabold));
           }





       });


    }


    public void Click(View view) {
        MediaPlayer mediaPlayer = MediaPlayer.create(Activity3.this, R.raw.qarakusu_paragit);
        mediaPlayer.start();

        view.setEnabled(false);
        ((ImageView)view).setImageResource(R.drawable.miqrafon_on);

        new CountDownTimer(15000, 1000) {
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