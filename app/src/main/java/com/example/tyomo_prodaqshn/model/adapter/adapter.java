package com.example.tyomo_prodaqshn.model.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tyomo_prodaqshn.R;
import com.example.tyomo_prodaqshn.model.users_models.UserModel;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.UserHolder> {
    int number1 = 0;
    private List<UserModel> list;
    Context context;

    public adapter(List<UserModel> list, Context context) {

        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public adapter.UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_user_item, parent, false);
        return new UserHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull adapter.UserHolder holder, int position) {
        // Сортируем список по балансу (от большего к меньшему)

        Collections.sort(list, new Comparator<UserModel>() {
            @Override
            public int compare(UserModel user1, UserModel user2) {
                if(user1.getTestBal() != null && user2.getTestBal() != null){
                    return Double.compare(user2.getTestBal().size(), user1.getTestBal().size());
                }
                else {
                    return Double.compare(0,0);
                }
                // Сравниваем балансы в обратном порядке (от большего к меньшему)

            }
        });

        // Устанавливаем данные в элементы ViewHolder
        holder.Name.setText(list.get(position).getName());
        if(list.get(position).getTestBal() != null){
            holder.bal.setText("" + list.get(position).getTestBal().size());
        }else {
            holder.bal.setText("0");
        }

        holder.number.setText(Integer.toString(position + 4));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


     class UserHolder extends RecyclerView.ViewHolder {
        private TextView Name;
        private TextView bal;
        private ImageView uzor;
        private TextView number;


        public UserHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.Name);
            bal = itemView.findViewById(R.id.bal);

            number = itemView.findViewById(R.id.number);



        }


    }

}