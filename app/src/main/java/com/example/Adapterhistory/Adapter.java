package com.example.Adapterhistory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.HistoryModel;
import com.example.quizapp2020ds.R;
import com.example.quizapp2020ds.databinding.ListBinding;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Adapter extends RecyclerView.Adapter <Adapter.ViewHolderHistory>{
List<HistoryModel> list=new ArrayList<>();


    public List<HistoryModel> getList() {
        return list;
    }

    public Adapter(List<HistoryModel> list) {
        this.list = list;
    }
    public void AdapterNotifiDataChanged(List<HistoryModel> list) {
        this.list = list;


      notifyDataSetChanged();

    }







    @NonNull
    @Override
    public ViewHolderHistory onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.listhistory,parent,false);



        return new ViewHolderHistory(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderHistory holder, int position) {
holder.OnBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolderHistory extends RecyclerView.ViewHolder{
        TextView history_time_text_view;
        TextView category_text_view_history;
        TextView correct_answers_text_view;
        TextView difficulty_text_view;
        ImageView imageView;
        CardView cardView;
    public ViewHolderHistory(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(itemView);
    history_time_text_view=itemView.findViewById(R.id.history_time_text_view);
    category_text_view_history=itemView.findViewById(R.id.category_text_view_history);
    correct_answers_text_view=itemView.findViewById(R.id.correct_answers_text_view);
    difficulty_text_view=itemView.findViewById(R.id.difficulty_text_view);
    imageView=itemView.findViewById(R.id.imageView);
     cardView=itemView.findViewById(R.id.cardView);


    }

        public void OnBind(HistoryModel s) {

            history_time_text_view.setText(s.getView1());
            category_text_view_history.setText(s.getView2());
            correct_answers_text_view.setText(s.getView3());
            difficulty_text_view.setText(s.getView4());



    }
    }
}
