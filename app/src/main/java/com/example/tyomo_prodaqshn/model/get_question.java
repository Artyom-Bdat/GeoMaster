package com.example.tyomo_prodaqshn.model;

import static com.example.tyomo_prodaqshn.MainActivity.mAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.tyomo_prodaqshn.MainActivity;
import com.example.tyomo_prodaqshn.R;
import com.example.tyomo_prodaqshn.model.users_models.Qmodel;
import com.example.tyomo_prodaqshn.online;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import www.sanju.motiontoast.MotionToast;
import www.sanju.motiontoast.MotionToastStyle;

public class get_question extends AppCompatActivity {

    EditText answer, question, name_question;
    Button get_question;
    ProgressBar progressBar;
    Qmodel qmodel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_question);

        answer = findViewById(R.id.answer);
        question = findViewById(R.id.question);
        name_question = findViewById(R.id.name_question);
        get_question = findViewById(R.id.get_question);
        progressBar = findViewById(R.id.progress_bar);
        mAuth = FirebaseAuth.getInstance();
        qmodel = new Qmodel();


        get_question.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email, password, name;
                email = String.valueOf(question.getText());
                password = String.valueOf(answer.getText());
                name = String.valueOf(name_question.getText());

                get_question.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.VISIBLE);

                if (TextUtils.isEmpty(name) || name.length() <= 3) {
                    get_question.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.INVISIBLE);
                    MotionToast.Companion.createColorToast(get_question.this, "Ошибка!",
                            "Введите Имя вопроса.",
                            MotionToastStyle.WARNING,
                            MotionToast.GRAVITY_BOTTOM,
                            MotionToast.LONG_DURATION,
                            ResourcesCompat.getFont(get_question.this, www.sanju.motiontoast.R.font.helveticabold));
                    return;
                }

                if (TextUtils.isEmpty(email) || email.length() <= 2) {
                    get_question.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.INVISIBLE);
                    MotionToast.Companion.createColorToast(get_question.this, "Ошибка!",
                            "Введите вопрос.",
                            MotionToastStyle.WARNING,
                            MotionToast.GRAVITY_BOTTOM,
                            MotionToast.LONG_DURATION,
                            ResourcesCompat.getFont(get_question.this, www.sanju.motiontoast.R.font.helveticabold));
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    get_question.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.INVISIBLE);
                    MotionToast.Companion.createColorToast(get_question.this, "Ошибка!",
                            "Введите ответ на вопрос.",
                            MotionToastStyle.WARNING,
                            MotionToast.GRAVITY_BOTTOM,
                            MotionToast.LONG_DURATION,
                            ResourcesCompat.getFont(get_question.this, www.sanju.motiontoast.R.font.helveticabold));
                    return;
                }

                // Обновляем значения полей объекта qmodel перед добавлением в Firestore
                qmodel.setQuestion(email);
                qmodel.setAnswer(password);
                qmodel.setQname(name);
                qmodel.setUserName(MainActivity.nameText);

                FirebaseFirestore.getInstance().collection("question")
                        .add(qmodel)
                        .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentReference> task) {
                                if (task.isSuccessful()) {
                                    // Документ успешно создан
                                    DocumentReference documentReference = task.getResult();
                                    String documentId = documentReference.getId();

                                    get_question.setVisibility(View.VISIBLE);
                                    progressBar.setVisibility(View.INVISIBLE);

                                    MotionToast.Companion.createColorToast(get_question.this,
                                            "Отлично!",
                                            "Вы создали вопрос!",
                                            MotionToastStyle.SUCCESS,
                                            MotionToast.GRAVITY_BOTTOM,
                                            MotionToast.LONG_DURATION,
                                            ResourcesCompat.getFont(get_question.this, www.sanju.motiontoast.R.font.helveticabold));


                                    Intent intent = new Intent(get_question.this, online.class);
                                    startActivity(intent);
                                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                                } else {
                                    // Произошла ошибка при создании документа
                                    get_question.setVisibility(View.VISIBLE);
                                    progressBar.setVisibility(View.INVISIBLE);
                                    MotionToast.Companion.createColorToast(get_question.this,
                                            "Ошибка!",
                                            "Произошла ошибка при создании вопроса!",
                                            MotionToastStyle.ERROR,
                                            MotionToast.GRAVITY_BOTTOM,
                                            MotionToast.LONG_DURATION,
                                            ResourcesCompat.getFont(get_question.this, www.sanju.motiontoast.R.font.helveticabold));
                                }
                            }
                        });
            }
        });


    }
        @Override
    public void onBackPressed(){
        Intent intent = new Intent(get_question.this,online.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

}
