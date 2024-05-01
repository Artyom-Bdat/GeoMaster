package com.example.tyomo_prodaqshn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseUser;

import www.sanju.motiontoast.MotionToast;
import www.sanju.motiontoast.MotionToastStyle;

public class sing_in extends AppCompatActivity {

    EditText editTextEmail, editTextPassword;
    Button login_btn;
    FirebaseAuth mAuth;
    TextView singin_buton;
    ProgressBar progressBar;


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            overridePendingTransition(0, 0);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_in);

        editTextEmail = findViewById(R.id.Email);
        editTextPassword = findViewById(R.id.password);
        login_btn = findViewById(R.id.login_btn);
        mAuth = FirebaseAuth.getInstance();
        singin_buton = findViewById(R.id.reg);
        progressBar = findViewById(R.id.progress_bar);

        singin_buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), sign_up.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                finish();
            }

        });

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email, password;
                email = String.valueOf(editTextEmail.getText());
                password = String.valueOf(editTextPassword.getText());
                login_btn.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.VISIBLE);

                if (TextUtils.isEmpty(email)) {
                    login_btn.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.INVISIBLE);
                    MotionToast.Companion.createColorToast(sing_in.this, "Ошибка!",
                            "Введите Email.",
                            MotionToastStyle.WARNING,
                            MotionToast.GRAVITY_BOTTOM,
                            MotionToast.LONG_DURATION,
                            ResourcesCompat.getFont(sing_in.this, www.sanju.motiontoast.R.font.helveticabold));
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    login_btn.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.INVISIBLE);
                    MotionToast.Companion.createColorToast(sing_in.this, "Ошибка!",
                            "Введите пароль.",
                            MotionToastStyle.WARNING,
                            MotionToast.GRAVITY_BOTTOM,
                            MotionToast.LONG_DURATION,
                            ResourcesCompat.getFont(sing_in.this, www.sanju.motiontoast.R.font.helveticabold));
                    return;
                }

                // Добавьте сюда ваш обработчик onComplete
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                                if (task.isSuccessful()) {
                                    if (firebaseAuth.getCurrentUser().isEmailVerified()) {
                                        login_btn.setVisibility(View.VISIBLE);
                                        progressBar.setVisibility(View.INVISIBLE);
                                        MotionToast.Companion.createColorToast(sing_in.this,
                                                "Отлично!",
                                                "Вы вошли в аккаунт!",
                                                MotionToastStyle.SUCCESS,
                                                MotionToast.GRAVITY_BOTTOM,
                                                MotionToast.LONG_DURATION,
                                                ResourcesCompat.getFont(sing_in.this, www.sanju.motiontoast.R.font.helveticabold));
                                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                        startActivity(intent);
                                        overridePendingTransition(0, 0);
                                        finish();
                                    } else {
                                        login_btn.setVisibility(View.VISIBLE);
                                        progressBar.setVisibility(View.INVISIBLE);
                                        MotionToast.Companion.createColorToast(sing_in.this,
                                                "Ошибка!",
                                                "Ваш аккаунт не подтвержден. Пожалуйста, проверьте свою почту и подтвердите аккаунт.",
                                                MotionToastStyle.ERROR,
                                                MotionToast.GRAVITY_BOTTOM,
                                                MotionToast.LONG_DURATION,
                                                ResourcesCompat.getFont(sing_in.this, www.sanju.motiontoast.R.font.helveticabold));
                                    }
                                } else {
                                    login_btn.setVisibility(View.VISIBLE);
                                    progressBar.setVisibility(View.INVISIBLE);
                                    Exception exception = task.getException();
                                    if (exception instanceof FirebaseAuthInvalidUserException) {
                                        // Пользователь с таким email не существует
                                        MotionToast.Companion.createColorToast(sing_in.this,
                                                "Ошибка!",
                                                "Пользователь с таким email не существует.",
                                                MotionToastStyle.ERROR,
                                                MotionToast.GRAVITY_BOTTOM,
                                                MotionToast.LONG_DURATION,
                                                ResourcesCompat.getFont(sing_in.this, www.sanju.motiontoast.R.font.helveticabold));
                                    } else if (exception instanceof FirebaseAuthInvalidCredentialsException) {
                                        // Неправильный email или пароль
                                        MotionToast.Companion.createColorToast(sing_in.this,
                                                "Ошибка!",
                                                "Неправильный email или пароль.",
                                                MotionToastStyle.ERROR,
                                                MotionToast.GRAVITY_BOTTOM,
                                                MotionToast.LONG_DURATION,
                                                ResourcesCompat.getFont(sing_in.this, www.sanju.motiontoast.R.font.helveticabold));
                                    } else {
                                        // Обработка других ошибок
                                        MotionToast.Companion.createColorToast(sing_in.this,
                                                "Ошибка!",
                                                "Произошла ошибка. Пожалуйста, попробуйте снова.",
                                                MotionToastStyle.ERROR,
                                                MotionToast.GRAVITY_BOTTOM,
                                                MotionToast.LONG_DURATION,
                                                ResourcesCompat.getFont(sing_in.this, www.sanju.motiontoast.R.font.helveticabold));
                                    }
                                }
                            }
                        });
            }
        });
    }


        @Override
            public void onBackPressed() {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(sing_in.this);
                alertDialog.setTitle("Выход с приложения");
                alertDialog.setMessage("Вы хотите выйти из приложения?");
                alertDialog.setPositiveButton("Да", new DialogInterface.OnClickListener() {
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

