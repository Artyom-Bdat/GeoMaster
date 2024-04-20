package com.example.tyomo_prodaqshn.easy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.example.tyomo_prodaqshn.R;
import com.example.tyomo_prodaqshn.erankyun_start_patuhan;
import com.example.tyomo_prodaqshn.model.UserModel;
import com.example.tyomo_prodaqshn.patasxaner;
import com.example.tyomo_prodaqshn.strat_vibor;


import www.sanju.motiontoast.MotionToast;
import www.sanju.motiontoast.MotionToastStyle;

public class Leval_2 extends AppCompatActivity {

    EditText Leval_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leval2);

        Leval_2 = findViewById(R.id.patasxan_Level_2);
        Leval_2.setOnClickListener(v -> {
            if(patasxaner.patasxan_2[1].equals(Leval_2.getText().toString())){
                MotionToast.Companion.createColorToast(this,
                        "Ответ правелен!",
                        "Молодец!",
                        MotionToastStyle.SUCCESS,
                        MotionToast.GRAVITY_BOTTOM,
                        MotionToast.LONG_DURATION,
                        ResourcesCompat.getFont(this, www.sanju.motiontoast.R.font.helveticabold));
                Intent intent = new Intent(Leval_2.this, very_easy.class);
                startActivity(intent);
                UserModel.baler(Leval_2.this);
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
        Intent intent = new Intent(Leval_2.this, very_easy.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    public void info(View view) {
        Intent intent = new Intent(Leval_2.this, erankyun_start_patuhan.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }
}