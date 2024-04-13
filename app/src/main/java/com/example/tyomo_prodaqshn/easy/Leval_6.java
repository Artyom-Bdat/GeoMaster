package com.example.tyomo_prodaqshn.easy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.example.tyomo_prodaqshn.R;
import com.example.tyomo_prodaqshn.model.UserModel;
import com.example.tyomo_prodaqshn.patasxaner;
import com.example.tyomo_prodaqshn.sexan_start_patuhan;
import com.example.tyomo_prodaqshn.strat_vibor;


import www.sanju.motiontoast.MotionToast;
import www.sanju.motiontoast.MotionToastStyle;

public class Leval_6 extends AppCompatActivity {

    EditText Leval_6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leval6);

        Leval_6 = findViewById(R.id.patasxan_Level_6);
        Leval_6.setOnClickListener(v -> {
            if(patasxaner.patasxan_2[5].equals(Leval_6.getText().toString())){
                MotionToast.Companion.createColorToast(this,
                        "Ответ правелен!",
                        "Молодец!",
                        MotionToastStyle.SUCCESS,
                        MotionToast.GRAVITY_BOTTOM,
                        MotionToast.LONG_DURATION,
                        ResourcesCompat.getFont(this, www.sanju.motiontoast.R.font.helveticabold));
                Intent intent = new Intent(Leval_6.this, very_easy.class);
                startActivity(intent);
                UserModel.baler(Leval_6.this);

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
        Intent intent = new Intent(Leval_6.this, very_easy.class);
        startActivity(intent);
    }

    public void info(View view) {
        Intent intent = new Intent(Leval_6.this, sexan_start_patuhan.class);
        startActivity(intent);
    }
}
