package com.example.quizapp2020ds.ui.quiz;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.os.CountDownTimer;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;


import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;


import com.example.quizapp2020ds.MainActivity;
import com.example.quizapp2020ds.R;
import com.example.quizapp2020ds.ui.main.MainFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class QuizActivity extends AppCompatActivity implements OnButtonAnswerClick {

    public static final String RESULT_QUESTIONS_AMOUNT_KEY = "RESULT_QUESTIONS_AMOUNT_KEY";

    QuizViewModel viewModel;
    RecyclerView recyclerView;
    QuizAdapter adapter;
    TextView progress;
    Question question;
    List<Question> list = new ArrayList<>();
    OnButtonAnswerClick onButtonAnswerClick;
ImageView BackImage;
    private static final String ANY_CATEGORY = "ANY CATEGORY";
    public static final String SEEK_BAR = "amount";
    public static final String DIFF_DIFFICULT = "difficult";
    public static final String CATEG_ID = "category_id";
    public static final String CATEGORY_NAME = "category";
    int category;
    String difficulty;
    int amount;
    public SeekBar progressbar;

    Button skip;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qui__light);
        skip = findViewById(R.id.skip);
        progressbar = findViewById(R.id.progressBar);

       progress=findViewById(R.id.progress);
        viewModel = ViewModelProviders.of(this).get(QuizViewModel.class);


        getQuizData();


        recyclerView = findViewById(R.id.recyclerQuizActivity);

        adapter = new QuizAdapter(this);

        recyclerView.setHasFixedSize(true);

BackImage=findViewById(R.id.Vimage);



        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);
        recyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);

        viewModel.currentQuestionPosition.observeForever(new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                progressbar.setMax(amount);
                recyclerView.smoothScrollToPosition(integer);

       progressbar.setProgress(integer);
                progress.setText(String.valueOf(integer)+"/"+String.valueOf(amount));
                viewModel.currentQuestionPosition.observeForever(quizModels -> adapter.ChangeAdapter(list));
            }
        });






        viewModel.getQuestion();
        viewModel.questions.observe(this, new Observer<List<Question>>() {
            @Override
            public void onChanged(List<Question> questions) {
                list.addAll(questions);
                adapter.notifyDataSetChanged();



            }
        });



try {
    BackImage.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {try {



            viewModel.onBackpessed();
        }catch (NullPointerException BackIgnor){

        }



        }
    });
}catch (Exception e){



}



        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                viewModel.onSkipClick();

            }
        });


    }











    public static void start(Context context, int amount, int category, String difficultValue) {

        Intent intent = new Intent(context, QuizActivity.class);
        intent.putExtra(SEEK_BAR, amount);
        intent.putExtra(CATEGORY_NAME, category);
        intent.putExtra(DIFF_DIFFICULT, difficultValue);
        context.startActivity(intent);


    }

    private void getQuizData() {
        try {

            Intent intent = getIntent();
            amount = intent.getIntExtra(SEEK_BAR, 5);
            category = intent.getIntExtra(CATEGORY_NAME, 0);

            String difficulty = (Objects.requireNonNull(intent.getStringExtra(DIFF_DIFFICULT)).toLowerCase());
            if (difficulty.equals("ANY DIFFICULTY")) {
                difficulty = null;
            }
        } catch (Exception e) {


        }


    }










    @Override
    public void onClick(View view, int PositionQuestion, int positionAnswer) {
        viewModel.onSkipClick();






        }

    }
