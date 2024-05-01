package com.example.tyomo_prodaqshn.model.users_models;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;

import com.example.tyomo_prodaqshn.Activity3;
import com.example.tyomo_prodaqshn.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import www.sanju.motiontoast.MotionToast;
import www.sanju.motiontoast.MotionToastStyle;

public class UserModel {



    private String name;
    private int bal;
    private String Emil;
    private String Password;
    static FirebaseAuth mAuth = FirebaseAuth.getInstance();



    public UserModel() {
    }

    public UserModel(String name, int bal, String emil, String password) {
        this.name = name;
        this.bal = bal;
        Emil = emil;
        Password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBal() {
        return bal;
    }

    public void setBal(int bal) {
        this.bal = bal;
    }

    public String getEmil() {
        return Emil;
    }

    public void setEmil(String emil) {
        Emil = emil;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public  static void baler(Context context){

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference userDocument = db.collection("users").document(mAuth.getCurrentUser().getUid());



        // Увеличиваем значение "bal" на 1 в Firestore
        userDocument.update("bal", FieldValue.increment(1))
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // Успешно увеличили значение "bal" на 1

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Ошибка при обновлении значения "bal"
                        Log.e("Firestore", "Ошибка при обновлении 'bal': " + e.getMessage());
                        // Можно показать уведомление об ошибке
                    }
                });
    }




}

