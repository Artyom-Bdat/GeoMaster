package com.example.tyomo_prodaqshn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tyomo_prodaqshn.madium.Leval_13;
import com.example.tyomo_prodaqshn.madium.Leval_14;
import com.example.tyomo_prodaqshn.madium.Leval_15;
import com.example.tyomo_prodaqshn.madium.Leval_16;
import com.example.tyomo_prodaqshn.madium.Leval_17;
import com.example.tyomo_prodaqshn.madium.Leval_18;
import com.example.tyomo_prodaqshn.madium.madium;
import com.example.tyomo_prodaqshn.model.Lideri;
import com.example.tyomo_prodaqshn.model.UserModel;
import com.example.tyomo_prodaqshn.model.adapter;
import com.example.tyomo_prodaqshn.model.question_adapter;
import com.example.tyomo_prodaqshn.model.question_model;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class qetion extends AppCompatActivity {

    private List<question_model> list;
    private RecyclerView recyclerView;
    private TextView Title;
    question_adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qetion);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(qetion.this));
        FirebaseAuth auth = FirebaseAuth.getInstance();
        list = new ArrayList<>();
        adapter = new question_adapter(list, qetion.this);
        recyclerView.setAdapter(adapter);

        loadDataFromFirestore();

    }


    @SuppressLint("NotifyDataSetChanged")
    private void loadDataFromFirestore() {


        Random random = new Random();
        // Генерируем случайное число от 1 до 6
        int randomLevel = random.nextInt(6) + 1;

        // Создаем Intent для запуска соответствующего уровня
        Intent intent;
        switch (randomLevel) {
            case 1:
                if (list.size() == 1) {
                    list.remove(0);
                }
                list.add(new question_model("Задан треугольник ABC,длины сторон которого AC=17,BC=14,Угол ABC = 60.Найти длину третьей стороны рассматриваемого треугольника.", "247", ""));
                adapter.notifyDataSetChanged();

                break;
            case 2:
                if (list.size() == 1) {
                    list.remove(0);
                }
                list.add(new question_model("В треугольнике ABC, угол A = 45 градусов,C = 15 градусов,BC = 4√6.Найти AC.", "12", ""));
                adapter.notifyDataSetChanged();
                break;
            case 3:
                if (list.size() == 1) {
                    list.remove(0);
                }
                list.add(new question_model("Найти C если a = 10,b = 5,h = 7.", "55.25", "imageView22"));
                adapter.notifyDataSetChanged();
                break;
            case 4:
                if (list.size() == 1) {
                    list.remove(0);
                }
                list.add(new question_model("3Задан треугольник ABC,длины сторон которого AC=17,BC=14,Угол ABC = 60.Найти длину третьей стороны рассматриваемого треугольника.", "247", ""));
                adapter.notifyDataSetChanged();
                break;
            case 5:
                if (list.size() == 1) {
                    list.remove(0);
                }
                list.add(new question_model("Зад4ан треугольник ABC,длины сторон которого AC=17,BC=14,Угол ABC = 60.Найти длину третьей стороны рассматриваемого треугольника.", "247", ""));
                adapter.notifyDataSetChanged();
                break;
            case 6:
                if (list.size() == 1) {
                    list.remove(0);
                }
                list.add(new question_model("5Задан5 треугольник ABC,длины сторон которого AC=17,BC=14,Угол ABC = 60.Найти длину третьей стороны рассматриваемого треугольника.", "247", ""));
                adapter.notifyDataSetChanged();
                break;
            default:
                list.add(new question_model("5Задан5 треугольник ABC,длины сторон которого AC=17,BC=14,Угол ABC = 60.Найти длину третьей стороны рассматриваемого треугольника.", "247", ""));
                adapter.notifyDataSetChanged();
                break;
        }

    }
}


