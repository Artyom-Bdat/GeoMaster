package com.example.tyomo_prodaqshn;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {

    TextView TextView;
    FirebaseAuth auth;
    Button logout;
    FirebaseUser User;



    public static  TextView bali;
    public static int bal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button start = findViewById(R.id.start);

        View.OnClickListener oclstart = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, strat_vibor.class);
                startActivity(intent);
            }
        };
        start.setOnClickListener(oclstart);



        auth = FirebaseAuth.getInstance();
        logout = findViewById(R.id.logout);
        TextView = findViewById(R.id.user_detalis);
        bali = findViewById(R.id.bali);
        User = auth.getCurrentUser();

        bali.setText(Integer.toString(bal));



        if(User == null){
            Intent intent = new Intent(getApplicationContext(),sing_in.class);
            startActivity(intent);
            finish();

        }
        else {
            TextView.setText(User.getEmail());

        }

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(),sing_in.class);
                startActivity(intent);
                finish();
            }
        });

    }


    @Override
    public void onBackPressed(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("Выход с приложения");
        alertDialog.setMessage("Вы хотите выйти из приложения?");
        alertDialog.setPositiveButton("Да",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
            }
        });
        alertDialog.setNegativeButton("Нет", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.show();
    }


    public void Click(View view) {
        Intent intent = new Intent(MainActivity.this, info.class);
        startActivity(intent);
    }
}