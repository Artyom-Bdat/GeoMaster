package com.example.tyomo_prodaqshn.east_2;

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

import www.sanju.motiontoast.MotionToast;
import www.sanju.motiontoast.MotionToastStyle;

public class Leval_8 extends AppCompatActivity {

    EditText Leval_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leval8);

        Leval_1 = findViewById(R.id.patasxan_Level_1);
        Leval_1.setOnClickListener(v -> {
            if (patasxaner.Hesht[1].equals(Leval_1.getText().toString())) {
                MotionToast.Companion.createColorToast(this,
                        "Ответ правелен!",
                        "Молодец!",
                        MotionToastStyle.SUCCESS,
                        MotionToast.GRAVITY_BOTTOM,
                        MotionToast.LONG_DURATION,
                        ResourcesCompat.getFont(this, www.sanju.motiontoast.R.font.helveticabold));
                Intent intent = new Intent(Leval_8.this, easy.class);
                startActivity(intent);
                UserModel.baler(Leval_8.this);
                overridePendingTransition(0, 0);
            } else {
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
    public void onBackPressed() {
        Intent intent = new Intent(Leval_8.this, easy.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    public void info(View view) {
        Intent intent = new Intent(Leval_8.this, klor_diametr_radius.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }
}