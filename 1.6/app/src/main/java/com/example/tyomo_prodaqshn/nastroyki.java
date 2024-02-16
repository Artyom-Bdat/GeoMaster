package com.example.tyomo_prodaqshn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class nastroyki extends AppCompatActivity {

   Button nazad_nastroyka;
   Button music;
   MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nastroyki);

        nazad_nastroyka = findViewById(R.id.nazad_nastroyka);
        nazad_nastroyka.setOnClickListener(v -> {
            Intent intent = new Intent(nastroyki.this, MainActivity.class);
            startActivity(intent);
        });


        music = findViewById(R.id.music);
        music.setOnClickListener(v -> {
            if(mediaPlayer.isPlaying()){
                pause();
            }else{
                play();
            }
        });
        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.music);

    }
    public void play(){
        mediaPlayer.start();
        music.setText("Pause");
    }

    public void pause(){
        mediaPlayer.pause();
        music.setText("Play");
    }
}