package com.example.tyomo_prodaqshn.model.users_models;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.content.res.ResourcesCompat;

import com.example.tyomo_prodaqshn.Activity3;
import com.example.tyomo_prodaqshn.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import www.sanju.motiontoast.MotionToast;
import www.sanju.motiontoast.MotionToastStyle;

public class UserModel {



    private String name;
    private int bal;
    private String Emil;
    private String Password;
    static FirebaseAuth mAuth = FirebaseAuth.getInstance();
    List<String> testBal;



    public UserModel() {
    }

    public UserModel(String name, int bal, String emil, String password) {
        this.name = name;
        this.bal = bal;
        Emil = emil;
        Password = password;
    }

    public UserModel(String name, int bal, String emil, String password, List<String> testBal) {
        this.name = name;
        this.bal = bal;
        this.Emil = emil;
        this.Password = password;
        this.testBal = testBal;
    }

    public static FirebaseAuth getmAuth() {
        return mAuth;
    }

    public static void setmAuth(FirebaseAuth mAuth) {
        UserModel.mAuth = mAuth;
    }

    public List<String> getTestBal() {
        return testBal;
    }

    public void setTestBal(List<String> testBal) {
        this.testBal = testBal;
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
        Toast.makeText(context, "HI", Toast.LENGTH_SHORT).show();

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference userDocument = db.collection("users").document(mAuth.getCurrentUser().getUid());
        userDocument.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @RequiresApi(api = Build.VERSION_CODES.Q)
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){

                    UserModel model = task.getResult().toObject(UserModel.class);
                    if(model.getTestBal() != null){
                        if(!model.getTestBal().contains(context.getClass().getSimpleName())){
                           Map<String,Object> testBal = new HashMap<>();
                           List<String> list = model.getTestBal();
                           list.add(context.getClass().getSimpleName());
                           testBal.put("testBal",list);
                           userDocument.update(testBal).addOnSuccessListener(new OnSuccessListener<Void>() {
                               @Override
                               public void onSuccess(Void unused) {
                                   Toast.makeText(context, "barev goxer", Toast.LENGTH_SHORT).show();
                               }
                           });

                        }
                    }else{
                        Map<String,Object> testBal = new HashMap<>();
                        List<String> list = new ArrayList<>();
                        list.add(context.getClass().getSimpleName());
                        testBal.put("testBal",list);
                        userDocument.update(testBal).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(context, "barev goxer", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }
            }
        });



        // Увеличиваем значение "bal" на 1 в Firestore

    }




}

