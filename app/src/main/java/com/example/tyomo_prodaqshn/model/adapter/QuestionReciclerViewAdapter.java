package com.example.tyomo_prodaqshn.model.adapter;



import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tyomo_prodaqshn.R;
import com.example.tyomo_prodaqshn.model.users_models.Qmodel;
import com.example.tyomo_prodaqshn.online_question;

import java.util.List;

public class QuestionReciclerViewAdapter extends RecyclerView.Adapter<QuestionReciclerViewAdapter.UserModelViewHolder> {
    Context context;
    List<Qmodel> list;
    onSelected selected;

    public QuestionReciclerViewAdapter(List<Qmodel> list, Context context) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public UserModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_item, parent, false);
        return new UserModelViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserModelViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.usernameText.setText(list.get(position).getUserName());
        holder.questionName.setText(list.get(position).getQname());
        holder.number.setText(Integer.toString(position + 1) + ")");

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, online_question.class);
                intent.putExtra("question",list.get(position).getQuestion());
                intent.putExtra("answer",list.get(position).getAnswer());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface onSelected{

        void onSelect(int position, String qname, String username, String question, String answer);
    }
    public void onSelected(onSelected selected){this.selected = selected;}


    class UserModelViewHolder extends RecyclerView.ViewHolder {
        TextView usernameText;
        TextView questionName;
        LinearLayout layout;
        TextView number;

        public UserModelViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.user_item);
            usernameText = itemView.findViewById(R.id.user_name_text);
            questionName = itemView.findViewById(R.id.question_name);
            number = itemView.findViewById(R.id.number);

        }

        public void setOnClickListener(int position, String Qname,String question,String answer, String Username) {
            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selected.onSelect(position,Qname,Username,question,answer);
                }
            });
        }
    }
}