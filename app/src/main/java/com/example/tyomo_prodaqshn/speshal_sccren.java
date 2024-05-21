package com.example.tyomo_prodaqshn;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

public class speshal_sccren extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speshal_sccren);



        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(3000);
                    startActivity(new Intent(speshal_sccren.this, sing_in.class));
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    finish();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

    @Override
    public void onBackPressed(){
        // Ваш код здесь
    }
}
