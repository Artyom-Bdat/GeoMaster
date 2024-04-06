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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tyomo_prodaqshn.model.UserModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import www.sanju.motiontoast.MotionToast;
import www.sanju.motiontoast.MotionToastStyle;

public class sign_up extends AppCompatActivity {

    EditText editTextEmail, editTextPassword, editTextName;
    Button register_btn;
    FirebaseAuth mAuth;
    Button sing_up;
    UserModel userModel;
    private Notification.Builder progressBar;

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
        userModel = new UserModel();

        editTextName = findViewById(R.id.Name);
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
                String email,password,name;
                email = String.valueOf(editTextEmail.getText());
                password = String.valueOf(editTextPassword.getText());
                name = String.valueOf(editTextName.getText());

                if(TextUtils.isEmpty(name) || name.length() <= 3){

                    MotionToast.Companion.createColorToast(sign_up.this,"Ошибка!",
                            "Введите Имя ползватьеля.",
                            MotionToastStyle.WARNING,
                            MotionToast.GRAVITY_BOTTOM,
                            MotionToast.LONG_DURATION,
                            ResourcesCompat.getFont(sign_up.this, www.sanju.motiontoast.R.font.helveticabold));
                    return;

                }


                if(TextUtils.isEmpty(email) | email.length() <= 12){

                    MotionToast.Companion.createColorToast(sign_up.this,"Ошибка!",
                            "Введите Email.",
                            MotionToastStyle.WARNING,
                            MotionToast.GRAVITY_BOTTOM,
                            MotionToast.LONG_DURATION,
                            ResourcesCompat.getFont(sign_up.this, www.sanju.motiontoast.R.font.helveticabold));
                    return;

                }

                if(TextUtils.isEmpty(password) | password.length() <= 6){

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

                                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                                if (task.isSuccessful()) {
                                    userModel.setBal(0);
                                    userModel.setEmil(email);
                                    userModel.setPassword(password);
                                    userModel.setName(name);

                                        FirebaseFirestore.getInstance().collection("users").document(mAuth.getCurrentUser().getUid()).set(userModel).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {

                                                if (task.isSuccessful()) {

                                                    firebaseAuth.getCurrentUser().sendEmailVerification();
                                                    firebaseAuth.signOut();
                                                    startActivity(new Intent(sign_up.this, sing_in.class));
                                                    finish();


                                                    MotionToast.Companion.createColorToast(sign_up.this,
                                                            "Отлично!",
                                                            "Аккаунт создан!",
                                                            MotionToastStyle.SUCCESS,
                                                            MotionToast.GRAVITY_BOTTOM,
                                                            MotionToast.LONG_DURATION,
                                                            ResourcesCompat.getFont(sign_up.this, www.sanju.motiontoast.R.font.helveticabold));
                                                }
                                            }
                                        });



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