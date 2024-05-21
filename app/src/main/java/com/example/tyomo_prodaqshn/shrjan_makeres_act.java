package com.example.tyomo_prodaqshn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.tyomo_prodaqshn.model.users_models.UserModel;

import www.sanju.motiontoast.MotionToast;
import www.sanju.motiontoast.MotionToastStyle;

public class shrjan_makeres_act extends AppCompatActivity {

    EditText pastxan_makeres_klor;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shrjan_makeres);

        pastxan_makeres_klor = findViewById(R.id.patasxan_Makeres_klor);
        pastxan_makeres_klor.setOnClickListener(v -> {
            if(patasxaner.patasxan[4].equals(pastxan_makeres_klor.getText().toString())){
                MotionToast.Companion.createColorToast(this,
                        "Ответ правелен!",
                        "Молодец!",
                        MotionToastStyle.SUCCESS,
                        MotionToast.GRAVITY_BOTTOM,
                        MotionToast.LONG_DURATION,
                        ResourcesCompat.getFont(this, www.sanju.motiontoast.R.font.helveticabold));
                Intent intent = new Intent(shrjan_makeres_act.this, klor_diametr_radius.class);
                startActivity(intent);
                UserModel.baler(shrjan_makeres_act.this);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
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
        // Остановить проигрывание звука, если он был запущен
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        Intent intent = new Intent(shrjan_makeres_act.this, klor_diametr_radius.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    private boolean isPlaying = false; // Переменная для отслеживания состояния воспроизведения



    @Override
    protected void onStop() {
        super.onStop();
        // Остановить воспроизведение звука при уходе из активности
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }


    public void Click(View view) {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
            // Обновляем изображение кнопки
            ((ImageView)view).setImageResource(R.drawable.miqrafon_off);
            Log.d("MediaPlayer", "Media player stopped");
        } else {
            mediaPlayer = MediaPlayer.create(shrjan_makeres_act.this, R.raw.klor_mkeres);
            mediaPlayer.start();
            // Обновляем изображение кнопки
            ((ImageView)view).setImageResource(R.drawable.miqrafon_on);
            Log.d("MediaPlayer", "Media player started");
            startTimer(view); // Запускаем таймер при начале воспроизведения звука
        }
    }

    private void startTimer(final View view) {
        new CountDownTimer(6000, 1000) {
            public void onTick(long millisUntilFinished) {
                // Здесь можно добавить обновление интерфейса, например, отображение оставшегося времени
            }

            public void onFinish() {
                // По завершению таймера, восстанавливаем доступ к кнопке микрофона
                view.setEnabled(true);
                // Обновляем изображение кнопки
                ((ImageView)view).setImageResource(R.drawable.miqrafon_off);
                // Останавливаем воспроизведение звука
                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    mediaPlayer = null;
                }
            }
        }.start();
    }

}