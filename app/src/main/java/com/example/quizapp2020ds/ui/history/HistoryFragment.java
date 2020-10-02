package com.example.quizapp2020ds.ui.history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Adapterhistory.Adapter;
import com.example.model.HistoryModel;
import com.example.quizapp2020ds.R;
import com.example.quizapp2020ds.ui.main.MainFragment;

import java.util.ArrayList;
import java.util.List;


public class HistoryFragment extends Fragment {


    RecyclerView recyclerView;
    Adapter adapter;
    List<HistoryModel> list=new ArrayList<HistoryModel>();
    HistoryModel historyModel;
    private HistoryViewModel mViewModel;

    public static HistoryFragment newInstance() {
        return new HistoryFragment();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.history_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(HistoryViewModel.class);

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    recyclerView=view.findViewById(R.id.history_recycle_view);
    recyclerView.setHasFixedSize(true);

    adapter=new Adapter(list);
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    recyclerView.setAdapter(adapter);





   for (int i =0;i<1;i++){

        historyModel=new HistoryModel("12 may 2019 20:32","Category","Correct_answers:8/10","Difficulty_easy","","");
       HistoryModel historyModel1=new HistoryModel("12 may 2019 20:32","Category","Correct_answers:8/10","Difficulty_All","","");
   list.add(historyModel);
   list.add(historyModel1);
  adapter.notifyDataSetChanged();
   }

    }
}