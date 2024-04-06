package com.example.tyomo_prodaqshn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.tyomo_prodaqshn.model.Lideri;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


public class MainActivity extends AppCompatActivity {

    TextView TextView;
    TextView name;
    FirebaseAuth auth;
    Button logout;
    FirebaseUser User;
    public static FirebaseAuth mAuth;



    public static  TextView bali;
    public static int bal = 0;
    long bal1;

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
        name = findViewById(R.id.user_name);
        bali = findViewById(R.id.bali);
        User = auth.getCurrentUser();
        mAuth = FirebaseAuth.getInstance();


        DocumentReference userDocument = FirebaseFirestore.getInstance().collection("users").document(mAuth.getCurrentUser().getUid());
        userDocument.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        // Получаем значение поля "bal" из документа

                        bali.setText(Long.toString( document.getLong("bal")));
                        name.setText(document.getString("name"));
                    } else {
                        Log.d("Firestore", "No such document");
                    }
                } else {
                    Log.d("Firestore", "get failed with ", task.getException());
                }
            }
        });





        if(User == null){
            Intent intent = new Intent(getApplicationContext(), sing_in.class);
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

    public void Lider(View view) {
        Intent intent = new Intent(MainActivity.this, Lideri.class);
        startActivity(intent);
    }
}