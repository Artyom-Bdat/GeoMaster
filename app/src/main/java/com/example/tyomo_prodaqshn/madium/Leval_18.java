package com.example.tyomo_prodaqshn.madium;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.tyomo_prodaqshn.R;
import com.example.tyomo_prodaqshn.model.UserModel;
import com.example.tyomo_prodaqshn.patasxaner;
import com.example.tyomo_prodaqshn.zugaheranist_start_patuhan;

import www.sanju.motiontoast.MotionToast;
import www.sanju.motiontoast.MotionToastStyle;

public class Leval_18 extends AppCompatActivity {

    EditText Leval_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leval18);

        Leval_1 = findViewById(R.id.patasxan_Level_1);
        Leval_1.setOnClickListener(v -> {
            if(patasxaner.madium[5].equals(Leval_1.getText().toString())){
                MotionToast.Companion.createColorToast(this,
                        "Ответ правелен!",
                        "Молодец!",
                        MotionToastStyle.SUCCESS,
                        MotionToast.GRAVITY_BOTTOM,
                        MotionToast.LONG_DURATION,
                        ResourcesCompat.getFont(this, www.sanju.motiontoast.R.font.helveticabold));
                Intent intent = new Intent(Leval_18.this, madium.class);
                startActivity(intent);
                UserModel.baler(Leval_18.this);

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
        Intent intent = new Intent(Leval_18.this, madium.class);
        startActivity(intent);
    }

    public void info(View view) {
        Intent intent = new Intent(Leval_18.this, zugaheranist_start_patuhan.class);
        startActivity(intent);
    }

}