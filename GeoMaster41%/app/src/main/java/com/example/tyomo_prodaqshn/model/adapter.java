package com.example.tyomo_prodaqshn.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tyomo_prodaqshn.R;

import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.UserHolder> {
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
        holder.name.setText(list.get(position).getName());
        holder.bal.setText("" + list.get(position).getBal());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


     class UserHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView bal;
        private TextView uzor;


        public UserHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.Name);
            bal = itemView.findViewById(R.id.bal);
            uzor = itemView.findViewById(R.id.uzor);



        }


    }

}