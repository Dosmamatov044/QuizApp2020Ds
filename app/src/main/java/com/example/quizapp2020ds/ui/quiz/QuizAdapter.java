package com.example.quizapp2020ds.ui.quiz;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizapp2020ds.R;
import com.example.quizapp2020ds.databinding.ListBinding;

import java.util.ArrayList;
import java.util.List;


public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.ViewHolder> {
    private List<Question> list = new ArrayList<>();
    private OnButtonAnswerClick answerClick;

    public QuizAdapter(OnButtonAnswerClick viewModel) {
        this.answerClick = viewModel;
    }

    public void ChangeAdapter(List<Question>list){
        this.list=list;
        notifyDataSetChanged();



    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }






    public class ViewHolder extends RecyclerView.ViewHolder  {
        private ListBinding listBinding;
        @SuppressLint("ClickableViewAccessibility")
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            listBinding = ListBinding.bind(itemView);

        }

        public void onBind(Question quizModel){
            quizModel.setId(getAdapterPosition());
           listBinding.setModel(quizModel);
            listBinding.setHandlers(answerClick);

        }




}}
