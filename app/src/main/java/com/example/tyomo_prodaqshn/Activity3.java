package com.example.tyomo_prodaqshn;

import static com.example.tyomo_prodaqshn.MainActivity.mAuth;

import androidx.annotation.NonNull;
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

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import www.sanju.motiontoast.MotionToast;
import www.sanju.motiontoast.MotionToastStyle;

public class Activity3 extends AppCompatActivity   {
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
               MotionToast.Companion.createColorToast(this,
                       "Ответ правелен!",
                       "Молодец!",
                       MotionToastStyle.SUCCESS,
                       MotionToast.GRAVITY_BOTTOM,
                       MotionToast.LONG_DURATION,
                       ResourcesCompat.getFont(this, www.sanju.motiontoast.R.font.helveticabold));
               Intent intent = new Intent(Activity3.this, qarankyun_1.class);
               startActivity(intent);

               FirebaseFirestore db = FirebaseFirestore.getInstance();
               DocumentReference userDocument = db.collection("users").document(mAuth.getCurrentUser().getUid());

               // Увеличиваем значение "bal" на 1 в Firestore
               userDocument.update("bal", FieldValue.increment(1))
                       .addOnSuccessListener(new OnSuccessListener<Void>() {
                           @Override
                           public void onSuccess(Void aVoid) {
                               // Успешно увеличили значение "bal" на 1
                               MotionToast.Companion.createColorToast(Activity3.this,
                                       "Успех!",
                                       "Значение 'bal' увеличено на 1",
                                       MotionToastStyle.SUCCESS,
                                       MotionToast.GRAVITY_BOTTOM,
                                       MotionToast.LONG_DURATION,
                                       ResourcesCompat.getFont(Activity3.this, www.sanju.motiontoast.R.font.helveticabold));
                           }
                       })
                       .addOnFailureListener(new OnFailureListener() {
                           @Override
                           public void onFailure(@NonNull Exception e) {
                               // Ошибка при обновлении значения "bal"
                               Log.e("Firestore", "Ошибка при обновлении 'bal': " + e.getMessage());
                               // Можно показать уведомление об ошибке
                           }
                       });

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
        Intent intent = new Intent(Activity3.this,qarankyun_1.class);
        startActivity(intent);
    }

    public void Click(View view) {
        MediaPlayer mediaPlayer = MediaPlayer.create(Activity3.this, R.raw.qarakusu_paragit);
        mediaPlayer.start();

        view.setEnabled(false);
        ((ImageView)view).setImageResource(R.drawable.miqrafon_on);

        new CountDownTimer(23000, 1000) {
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