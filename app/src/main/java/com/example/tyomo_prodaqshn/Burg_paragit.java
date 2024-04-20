package com.example.tyomo_prodaqshn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.example.tyomo_prodaqshn.model.UserModel;

import www.sanju.motiontoast.MotionToast;
import www.sanju.motiontoast.MotionToastStyle;

public class Burg_paragit extends AppCompatActivity {

    EditText patasxan_inpat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burg_paragit);

        patasxan_inpat = findViewById(R.id.patasxan_inpat);
        patasxan_inpat.setOnClickListener(v -> {
            if(patasxaner.modek_3d[0].equals(patasxan_inpat.getText().toString())){
                MotionToast.Companion.createColorToast(this,
                        "Ответ правелен!",
                        "Молодец!",
                        MotionToastStyle.SUCCESS,
                        MotionToast.GRAVITY_BOTTOM,
                        MotionToast.LONG_DURATION,
                        ResourcesCompat.getFont(this, www.sanju.motiontoast.R.font.helveticabold));
                Intent intent = new Intent(Burg_paragit.this, burg_makeres.class);
                startActivity(intent);
                UserModel.baler(Burg_paragit.this);
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
        Intent intent = new Intent(Burg_paragit.this,burg_makeres.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }
}