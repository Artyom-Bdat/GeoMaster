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

public class klor_sigment extends AppCompatActivity {
    EditText patasxan_klor_sigment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klor_sigment);

        patasxan_klor_sigment = findViewById(R.id.patasxan_klor_sigment);
        patasxan_klor_sigment.setOnClickListener(v -> {
            if(patasxaner.patasxan[15].equals(patasxan_klor_sigment.getText().toString())){
                MotionToast.Companion.createToast(klor_sigment.this,
                        "Моладец!",
                        "Ответ привилен!",
                        MotionToastStyle.SUCCESS,
                        MotionToast.GRAVITY_BOTTOM,
                        MotionToast.LONG_DURATION,
                        ResourcesCompat.getFont(klor_sigment.this, www.sanju.motiontoast.R.font.helveticabold));
                Intent intent = new Intent(klor_sigment.this, klor_diametr_radius.class);
                startActivity(intent);
            }else{
                MotionToast.Companion.createToast(klor_sigment.this,
                        "Неправильно!",
                        "Подумай еще!",
                        MotionToastStyle.ERROR,
                        MotionToast.GRAVITY_BOTTOM,
                        MotionToast.LONG_DURATION,
                        ResourcesCompat.getFont(klor_sigment.this, www.sanju.motiontoast.R.font.helveticabold));
            }
        });
    }
    public void Click(View view) {
        MediaPlayer mediaPlayer = MediaPlayer.create(klor_sigment.this, R.raw.klor_sigment);
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