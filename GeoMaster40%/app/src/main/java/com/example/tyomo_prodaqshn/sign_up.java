package com.example.tyomo_prodaqshn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tyomo_prodaqshn.MainActivity;
import com.example.tyomo_prodaqshn.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import www.sanju.motiontoast.MotionToast;
import www.sanju.motiontoast.MotionToastStyle;

public class sign_up extends AppCompatActivity {

    EditText editTextEmail, editTextPassword;
    Button register_btn;
    FirebaseAuth mAuth;
    ProgressBar progressBar;
    Button sing_up;

    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        editTextEmail = findViewById(R.id.Email);
        editTextPassword = findViewById(R.id.password);
        register_btn = findViewById(R.id.register_btn);
        mAuth = FirebaseAuth.getInstance();
        sing_up = findViewById(R.id.singup_Button);

        sing_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), sing_in.class);
                startActivity(intent);
                finish();
            }

        });


        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email,password;
                email = String.valueOf(editTextEmail.getText());
                password = String.valueOf(editTextPassword.getText());

                if(TextUtils.isEmpty(email)){

                    MotionToast.Companion.createColorToast(sign_up.this,"Ошибка!",
                            "Введите Email.",
                            MotionToastStyle.WARNING,
                            MotionToast.GRAVITY_BOTTOM,
                            MotionToast.LONG_DURATION,
                            ResourcesCompat.getFont(sign_up.this, www.sanju.motiontoast.R.font.helveticabold));
                    return;

                }

                if(TextUtils.isEmpty(password)){

                    MotionToast.Companion.createColorToast(sign_up.this,"Ошибка!",
                            "Введите пароль.",
                            MotionToastStyle.WARNING,
                            MotionToast.GRAVITY_BOTTOM,
                            MotionToast.LONG_DURATION,
                            ResourcesCompat.getFont(sign_up.this, www.sanju.motiontoast.R.font.helveticabold));
                    return;

                }

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {


                                if (task.isSuccessful()) {

                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(intent);
                                    finish();

                                    MotionToast.Companion.createColorToast(sign_up.this,
                                            "Отлично!",
                                            "Аккаунт создан!",
                                            MotionToastStyle.SUCCESS,
                                            MotionToast.GRAVITY_BOTTOM,
                                            MotionToast.LONG_DURATION,
                                            ResourcesCompat.getFont(sign_up.this, www.sanju.motiontoast.R.font.helveticabold));


                                } else {
                                    // If sign in fails, display a message to the user.
                                    MotionToast.Companion.createColorToast(sign_up.this,
                                            "Ошибка!",
                                            "Подобный аккаунт уже существует!",
                                            MotionToastStyle.ERROR,
                                            MotionToast.GRAVITY_BOTTOM,
                                            MotionToast.LONG_DURATION,
                                            ResourcesCompat.getFont(sign_up.this, www.sanju.motiontoast.R.font.helveticabold));

                                }
                            }
                        });


            }
        });
    }

    @Override
    public void onBackPressed(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(sign_up.this);
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


}