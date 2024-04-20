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

import com.example.tyomo_prodaqshn.model.UserModel;

import www.sanju.motiontoast.MotionToast;
import www.sanju.motiontoast.MotionToastStyle;

public class klor_sektor extends AppCompatActivity {

    EditText klor_patasxan_sektor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klor_sektor);

        klor_patasxan_sektor = findViewById(R.id.klor_patasxan_sektor);
        klor_patasxan_sektor.setOnClickListener(v -> {
            if(patasxaner.patasxan[15].equals(klor_patasxan_sektor.getText().toString())){
                MotionToast.Companion.createColorToast(this,
                        "Ответ правелен!",
                        "Молодец!",
                        MotionToastStyle.SUCCESS,
                        MotionToast.GRAVITY_BOTTOM,
                        MotionToast.LONG_DURATION,
                        ResourcesCompat.getFont(this, www.sanju.motiontoast.R.font.helveticabold));
                Intent intent = new Intent(klor_sektor.this, klor_diametr_radius.class);
                startActivity(intent);
                UserModel.baler(klor_sektor.this);
                overridePendingTransition(0, 0);
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
        Intent intent = new Intent(klor_sektor.this, klor_diametr_radius.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    public void Click(View view) {
        MediaPlayer mediaPlayer = MediaPlayer.create(klor_sektor.this, R.raw.klor_sektor);
        mediaPlayer.start();

        view.setEnabled(false);
        ((ImageView)view).setImageResource(R.drawable.miqrafon_on);

        new CountDownTimer(16000, 1000) {
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