package com.example.tyomo_prodaqshn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class zugaheranist_start_patuhan extends AppCompatActivity {

    ImageView zugaheranist_paragit;
    ImageView zugaheranist_makeres;
    Button satrt_patuhan_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zugaheranist_start_patuhan);
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(zugaheranist_start_patuhan.this, start_patuhan.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    public void z_p(View view) {
        Intent intent = new Intent(zugaheranist_start_patuhan.this, zugaheranist_paragit_act.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    public void z_s(View view) {
        Intent intent = new Intent(zugaheranist_start_patuhan.this, zugaheranist_makeres_act.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    public void nazad(View view) {
        Intent intent = new Intent(zugaheranist_start_patuhan.this, start_patuhan.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}