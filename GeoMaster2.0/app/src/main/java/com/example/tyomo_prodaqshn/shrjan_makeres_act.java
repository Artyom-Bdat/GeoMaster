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

public class shrjan_makeres_act extends AppCompatActivity {

    EditText pastxan_makeres_klor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shrjan_makeres);

        pastxan_makeres_klor = findViewById(R.id.patasxan_Makeres_klor);
        pastxan_makeres_klor.setOnClickListener(v -> {
            if(patasxaner.patasxan[4].equals(pastxan_makeres_klor.getText().toString())){
                MotionToast.Companion.createToast(shrjan_makeres_act.this,
                        "Моладец!",
                        "Ответ привилен!",
                        MotionToastStyle.SUCCESS,
                        MotionToast.GRAVITY_BOTTOM,
                        MotionToast.LONG_DURATION,
                        ResourcesCompat.getFont(shrjan_makeres_act.this, www.sanju.motiontoast.R.font.helveticabold));
                Intent intent = new Intent(shrjan_makeres_act.this, klor_diametr_radius.class);
                startActivity(intent);
            }else{
                MotionToast.Companion.createToast(shrjan_makeres_act.this,
                        "Неправильно!",
                        "Подумай еще!",
                        MotionToastStyle.ERROR,
                        MotionToast.GRAVITY_BOTTOM,
                        MotionToast.LONG_DURATION,
                        ResourcesCompat.getFont(shrjan_makeres_act.this, www.sanju.motiontoast.R.font.helveticabold));
            }
        });
    }
    public void Click(View view) {
        MediaPlayer mediaPlayer = MediaPlayer.create(shrjan_makeres_act.this, R.raw.klor_mkeres);
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