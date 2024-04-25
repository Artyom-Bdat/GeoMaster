package com.example.tyomo_prodaqshn;

import static java.security.AccessController.getContext;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.tyomo_prodaqshn.model.adapter.QuestionReciclerViewAdapter;
import com.example.tyomo_prodaqshn.model.get_question;
import com.example.tyomo_prodaqshn.model.users_models.Qmodel;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class online extends AppCompatActivity {
    RecyclerView recyclerView;
    QuestionReciclerViewAdapter adapter;
    ArrayList<Qmodel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        list = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(online.this));
        adapter = new QuestionReciclerViewAdapter(list, online.this);
        recyclerView.setAdapter(adapter);

        loadQuestion();

        adapter.onSelected(new QuestionReciclerViewAdapter.onSelected() {
            @Override
            public void onSelect(int position, String qname, String username, String question, String answer) {
                // Здесь можете добавить код для обработки нажатия на элемент списка
            }
        });
    }

    private void loadQuestion() {
        CollectionReference reference = FirebaseFirestore.getInstance().collection("question");

        reference.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                if (error != null) {
                    Toast.makeText(online.this, "Ошибка загрузки вопросов", Toast.LENGTH_SHORT).show();
                    return;
                }

                list.clear(); // Очистим список перед добавлением новых данных

                for (DocumentSnapshot doc : value) {
                    Qmodel model = doc.toObject(Qmodel.class);
                    list.add(model);
                }
                adapter.notifyDataSetChanged(); // Обновим адаптер после загрузки новых данных
            }
        });
    }

    public void get_question(View view) {
        Intent intent = new Intent(online.this, get_question.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(online.this, strat_vibor.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
    }
}