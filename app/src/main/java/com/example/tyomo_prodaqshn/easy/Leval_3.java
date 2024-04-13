package com.example.tyomo_prodaqshn.easy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.example.tyomo_prodaqshn.R;
import com.example.tyomo_prodaqshn.klor_diametr_radius;
import com.example.tyomo_prodaqshn.model.UserModel;
import com.example.tyomo_prodaqshn.patasxaner;
import com.example.tyomo_prodaqshn.strat_vibor;


import www.sanju.motiontoast.MotionToast;
import www.sanju.motiontoast.MotionToastStyle;

public class Leval_3 extends AppCompatActivity {

    EditText Leval_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leval3);

        Leval_3 = findViewById(R.id.patasxan_Level_3);
        Leval_3.setOnClickListener(v -> {
            if(patasxaner.patasxan_2[2].equals(Leval_3.getText().toString())){
                MotionToast.Companion.createColorToast(this,
                        "Ответ правелен!",
                        "Молодец!",
                        MotionToastStyle.SUCCESS,
                        MotionToast.GRAVITY_BOTTOM,
                        MotionToast.LONG_DURATION,
                        ResourcesCompat.getFont(this, www.sanju.motiontoast.R.font.helveticabold));
                Intent intent = new Intent(Leval_3.this, very_easy.class);
                startActivity(intent);
                UserModel.baler(Leval_3.this);

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
        Intent intent = new Intent(Leval_3.this, very_easy.class);
        startActivity(intent);
    }

    public void info(View view) {
        Intent intent = new Intent(Leval_3.this, klor_diametr_radius.class);
        startActivity(intent);
    }
}
