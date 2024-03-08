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

public class sexan_makeres extends AppCompatActivity {
    EditText sexan_makeres_patasxan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sexan_makeres);
       sexan_makeres_patasxan = findViewById(R.id.sexan_makeres_patasxan);
       sexan_makeres_patasxan.setOnClickListener(v -> {
            if(patasxaner.patasxan[9].equals(sexan_makeres_patasxan.getText().toString())){
                MotionToast.Companion.createToast(sexan_makeres.this,
                        "Моладец!",
                        "Ответ привилен!",
                        MotionToastStyle.SUCCESS,
                        MotionToast.GRAVITY_BOTTOM,
                        MotionToast.LONG_DURATION,
                        ResourcesCompat.getFont(sexan_makeres.this, www.sanju.motiontoast.R.font.helveticabold));
                Intent intent = new Intent(sexan_makeres.this, sexan_start_patuhan.class);
                startActivity(intent);
            }else{
                MotionToast.Companion.createToast(sexan_makeres.this,
                        "Неправильно!",
                        "Подумай еще!",
                        MotionToastStyle.ERROR,
                        MotionToast.GRAVITY_BOTTOM,
                        MotionToast.LONG_DURATION,
                        ResourcesCompat.getFont(sexan_makeres.this, www.sanju.motiontoast.R.font.helveticabold));
            }
        });
    }
    public void Click(View view) {
        MediaPlayer mediaPlayer = MediaPlayer.create(sexan_makeres.this, R.raw.sexan_makeres);
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