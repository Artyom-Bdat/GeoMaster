package com.example.tyomo_prodaqshn.hard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.tyomo_prodaqshn.R;
import com.example.tyomo_prodaqshn.burg_makeres;
import com.example.tyomo_prodaqshn.model.UserModel;
import com.example.tyomo_prodaqshn.patasxaner;

import www.sanju.motiontoast.MotionToast;
import www.sanju.motiontoast.MotionToastStyle;

public class Leval_22 extends AppCompatActivity {

    EditText Leval_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leval22);

        Leval_1 = findViewById(R.id.patasxan_Level_1);
        Leval_1.setOnClickListener(v -> {
            if(patasxaner.hard[3].equals(Leval_1.getText().toString())){
                MotionToast.Companion.createColorToast(this,
                        "Ответ правелен!",
                        "Молодец!",
                        MotionToastStyle.SUCCESS,
                        MotionToast.GRAVITY_BOTTOM,
                        MotionToast.LONG_DURATION,
                        ResourcesCompat.getFont(this, www.sanju.motiontoast.R.font.helveticabold));
                Intent intent = new Intent(Leval_22.this, hard.class);
                startActivity(intent);
                UserModel.baler(Leval_22.this);
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
        Intent intent = new Intent(Leval_22.this, hard.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    public void info(View view) {
        Intent intent = new Intent(Leval_22.this, burg_makeres.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

}