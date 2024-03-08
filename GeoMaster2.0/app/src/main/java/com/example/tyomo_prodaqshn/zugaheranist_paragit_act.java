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

public class zugaheranist_paragit_act extends AppCompatActivity {
    EditText zugaheranist_paragit_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zugaheranist_paragit);
        zugaheranist_paragit_ = findViewById(R.id.zugaheranist_paragit_);
        zugaheranist_paragit_.setOnClickListener(v -> {
            if (patasxaner.patasxan[10].equals(zugaheranist_paragit_.getText().toString())) {
                MotionToast.Companion.createToast(zugaheranist_paragit_act.this,
                        "Моладец!",
                        "Ответ привилен!",
                        MotionToastStyle.SUCCESS,
                        MotionToast.GRAVITY_BOTTOM,
                        MotionToast.LONG_DURATION,
                        ResourcesCompat.getFont(zugaheranist_paragit_act.this, www.sanju.motiontoast.R.font.helveticabold));
                Intent intent = new Intent(zugaheranist_paragit_act.this, zugaheranist_start_patuhan.class);
                startActivity(intent);
            } else {
                MotionToast.Companion.createToast(zugaheranist_paragit_act.this,
                        "Неправильно!",
                        "Подумай еще!",
                        MotionToastStyle.ERROR,
                        MotionToast.GRAVITY_BOTTOM,
                        MotionToast.LONG_DURATION,
                        ResourcesCompat.getFont(zugaheranist_paragit_act.this, www.sanju.motiontoast.R.font.helveticabold));
            }
        });
    }

    public void Click(View view) {
        MediaPlayer mediaPlayer = MediaPlayer.create(zugaheranist_paragit_act.this, R.raw.zugaheraagit_paraagit);
        mediaPlayer.start();

        view.setEnabled(false);
        ((ImageView) view).setImageResource(R.drawable.miqrafon_on);

        new CountDownTimer(15000, 1000) {
            public void onTick(long millisUntilFinished) {
                // Здесь можно добавить обновление интерфейса, например, отображение оставшегося времени
            }

            public void onFinish() {
                // По завершению таймера, восстанавливаем доступ к кнопке микрофона
                view.setEnabled(true);
                ((ImageView) view).setImageResource(R.drawable.miqrafon_off);
            }
        }.start();
    }
}