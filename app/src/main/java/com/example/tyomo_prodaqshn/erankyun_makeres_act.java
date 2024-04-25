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

import com.example.tyomo_prodaqshn.model.users_models.UserModel;

import www.sanju.motiontoast.MotionToast;
import www.sanju.motiontoast.MotionToastStyle;

public class erankyun_makeres_act extends AppCompatActivity {
    EditText pastxan_erankyun_makeres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erankyun_makeres);
        pastxan_erankyun_makeres = findViewById(R.id.patasxan_erankyun_makeres);
        pastxan_erankyun_makeres.setOnClickListener(v -> {
            if(patasxaner.patasxan[7].equals(pastxan_erankyun_makeres.getText().toString())){
                MotionToast.Companion.createColorToast(this,
                        "Ответ правелен!",
                        "Молодец!",
                        MotionToastStyle.SUCCESS,
                        MotionToast.GRAVITY_BOTTOM,
                        MotionToast.LONG_DURATION,
                        ResourcesCompat.getFont(this, www.sanju.motiontoast.R.font.helveticabold));
                Intent intent = new Intent(erankyun_makeres_act.this, erankyun_start_patuhan.class);
                startActivity(intent);
                UserModel.baler(erankyun_makeres_act.this);
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
        Intent intent = new Intent(erankyun_makeres_act.this, erankyun_start_patuhan.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    public void Click(View view) {
        MediaPlayer mediaPlayer = MediaPlayer.create(erankyun_makeres_act.this, R.raw.erankyun_makeres);
        mediaPlayer.start();

        view.setEnabled(false);
        ((ImageView)view).setImageResource(R.drawable.miqrafon_on);

        new CountDownTimer(19000, 1000) {
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