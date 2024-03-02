package com.example.tyomo_prodaqshn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {
    ImageButton nastroyka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start = (Button) findViewById(R.id.start);
        View.OnClickListener oclstart = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(MainActivity.this,start_patuhan.class);
               startActivity(intent);
            }
        };

        start.setOnClickListener(oclstart);





    }

    public void Click(View view) {
        final MediaPlayer mediaPlayer =MediaPlayer.create(this,R.raw.clic);
        mediaPlayer.start();;
    }
}