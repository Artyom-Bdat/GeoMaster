package com.example.tyomo_prodaqshn.lider_bord;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tyomo_prodaqshn.MainActivity;
import com.example.tyomo_prodaqshn.R;
import com.example.tyomo_prodaqshn.model.adapter.adapter;
import com.example.tyomo_prodaqshn.model.users_models.UserModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lideri extends AppCompatActivity {
    private List<UserModel> list;
    private RecyclerView recyclerView;
    private TextView Title,top1,top2,top3,name1,name2,name3;
    int toper;
     com.example.tyomo_prodaqshn.model.adapter.adapter adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lideri);

        Title = findViewById(R.id.Title);

        recyclerView = findViewById(R.id.recyclerView);

        name1 = findViewById(R.id.Name1);
        name2 = findViewById(R.id.Name2);
        name3 = findViewById(R.id.Name3);


        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(Lideri.this));
        FirebaseAuth auth = FirebaseAuth.getInstance();
        list = new ArrayList<>();
        adapter = new adapter(list, Lideri.this);
        recyclerView.setAdapter(adapter);
        loadDataFromFirestore();

    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(Lideri.this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @SuppressLint("NotifyDataSetChanged")
    private void loadDataFromFirestore() {
        CollectionReference reference = FirebaseFirestore.getInstance().collection("users");

        reference.addSnapshotListener((value, error) -> {
            Log.e("reference updated", "reference");
            if (error != null) {
                Log.e("Error:", error.getMessage());
                return;
            }
            if (value == null || value.isEmpty()) {
                return; // No data in snapshot, just exit
            }

            // Clear the list before adding new data
            list.clear();

            int toper = 0;

            for (QueryDocumentSnapshot snapshot : value) {
                if (!snapshot.exists()) {
                    continue;
                }

                UserModel model = snapshot.toObject(UserModel.class);

                if (snapshot.getString("name") == null) {
                    Toast.makeText(this, "null", Toast.LENGTH_SHORT).show();
                }

                if (model.getTestBal() == null) {
                    list.add(new UserModel(
                            snapshot.getString("name"),
                            (int) Math.round(snapshot.getDouble("bal")),
                            model.getEmil(),
                            model.getPassword()
                    ));
                } else {
                    list.add(new UserModel(
                            snapshot.getString("name"),
                            (int) Math.round(snapshot.getDouble("bal")),
                            model.getEmil(),
                            model.getPassword(),
                            model.getTestBal()
                    ));
                }

            }

            Collections.sort(list, new Comparator<UserModel>() {
                @Override
                public int compare(UserModel user1, UserModel user2) {
                    if (user1.getTestBal() != null && user2.getTestBal() != null) {
                        return Double.compare(user2.getTestBal().size(), user1.getTestBal().size());
                    } else {
                        return Double.compare(0, 0);
                    }
                }
            });

            // Ensure the list has enough elements before accessing them
            while (toper < 3 && toper < list.size()) {
                if (toper == 0) {
                    if (list.get(toper) != null) {
                        name1.setText(list.get(toper).getName());
                    }
                }
                if (toper == 1) {
                    if (list.get(toper) != null) {
                        name2.setText(list.get(toper).getName());
                    }
                }
                if (toper == 2) {
                    if (list.get(toper) != null) {
                        name3.setText(list.get(toper).getName());
                    }
                }
                toper++;
            }

            // Remove the elements from the list after setting the names
            if (list.size() > 0) list.subList(0, Math.min(3, list.size())).clear();

            // Update the adapter after all data is added
            adapter.notifyDataSetChanged();
        });
    }
}


