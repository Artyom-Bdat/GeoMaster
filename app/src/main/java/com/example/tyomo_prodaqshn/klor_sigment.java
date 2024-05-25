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

public class klor_sigment extends AppCompatActivity {
    EditText patasxan_klor_sigment;
    private MediaPlayer mediaPlayer;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klor_sigment);

        patasxan_klor_sigment = findViewById(R.id.patasxan_klor_sigment);
        patasxan_klor_sigment.setOnClickListener(v -> {
            if(patasxaner.patasxan[15].equals(patasxan_klor_sigment.getText().toString())){
                MotionToast.Companion.createColorToast(this,
                        "Ответ правелен!",
                        "Молодец!",
                        MotionToastStyle.SUCCESS,
                        MotionToast.GRAVITY_BOTTOM,
                        MotionToast.LONG_DURATION,
                        ResourcesCompat.getFont(this, www.sanju.motiontoast.R.font.helveticabold));
                Intent intent = new Intent(klor_sigment.this, klor_diametr_radius.class);
                startActivity(intent);
                UserModel.baler(klor_sigment.this);
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
        Intent intent = new Intent(klor_sigment.this, klor_diametr_radius.class);
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

        // Отменить таймер при уходе из активности
        if (countDownTimer != null) {
            countDownTimer.cancel();
            countDownTimer = null;
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

            // Отменить текущий таймер
            if (countDownTimer != null) {
                countDownTimer.cancel();
                countDownTimer = null;
            }
        } else {
            mediaPlayer = MediaPlayer.create(klor_sigment.this, R.raw.klor_sigment);
            mediaPlayer.start();
            // Обновляем изображение кнопки
            ((ImageView)view).setImageResource(R.drawable.miqrafon_on);
            Log.d("MediaPlayer", "Media player started");
            startTimer(view); // Запускаем таймер при начале воспроизведения звука
        }
    }

    private void startTimer(final View view) {
        // Отменить текущий таймер, если он существует
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }

        countDownTimer = new CountDownTimer(8000, 1000) {
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