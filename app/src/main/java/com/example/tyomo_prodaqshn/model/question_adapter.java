package com.example.tyomo_prodaqshn.model;



import static androidx.core.content.ContextCompat.startActivity;

import android.app.Activity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tyomo_prodaqshn.R;
import com.example.tyomo_prodaqshn.madium.Leval_13;
import com.example.tyomo_prodaqshn.madium.madium;
import com.example.tyomo_prodaqshn.patasxaner;

import java.util.List;

import www.sanju.motiontoast.MotionToast;
import www.sanju.motiontoast.MotionToastStyle;

public class question_adapter extends  RecyclerView.Adapter<question_adapter.QuestionHolder> {

    private List<question_model> list;
    static Context context;
    onPressed onpressed;

    public question_adapter(List<question_model> list, Context context) {

        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public QuestionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_leval13, parent, false);
        return new question_adapter.QuestionHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionHolder holder, int position) {

        holder.question.setText(list.get(position).getQuestion());

        holder.answer.setOnClickListener(v -> {
            if(patasxaner.madium[0].equals( holder.answer.getText().toString())){
                MotionToast.Companion.createColorToast((Activity) context,
                        "Ответ правелен!",
                        "Молодец!",
                        MotionToastStyle.SUCCESS,
                        MotionToast.GRAVITY_BOTTOM,
                        MotionToast.LONG_DURATION,
                        ResourcesCompat.getFont(context, www.sanju.motiontoast.R.font.helveticabold));
                Intent intent = new Intent(context, madium.class);
                context.startActivity(intent);
                UserModel.baler(context);

            }else{
                MotionToast.Companion.createColorToast((Activity)context,
                        "Ответ неправильный!",
                        "подумай еще",
                        MotionToastStyle.ERROR,
                        MotionToast.GRAVITY_BOTTOM,
                        MotionToast.LONG_DURATION,
                        ResourcesCompat.getFont(context, www.sanju.motiontoast.R.font.helveticabold));
            }
        });


    }

    @Override
    public int getItemCount() {
        return 1;
    }
    public  interface onPressed{
        public void answer();
        public void info();
    }


    class QuestionHolder extends RecyclerView.ViewHolder {
        TextView question,  armat;
         EditText answer;
        ImageView info, qestion_png;


        public QuestionHolder(@NonNull View itemView) {
            super(itemView);

            question = itemView.findViewById(R.id.question);
            armat = itemView.findViewById(R.id.armat);
            answer = itemView.findViewById(R.id.patasxan_Level_1);
            info = itemView.findViewById(R.id.info);
            qestion_png = itemView.findViewById(R.id.qetion_Png);




        }


    }
}
