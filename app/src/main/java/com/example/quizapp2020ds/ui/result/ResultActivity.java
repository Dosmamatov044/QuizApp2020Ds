package com.example.quizapp2020ds.ui.result;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.quizapp2020ds.R;

public class ResultActivity extends AppCompatActivity {

     TextView resultTitle;
     TextView resultCategory;
     TextView resulDiff;

     TextView result_Correct_Answers;
     TextView result;
     TextView all;
     TextView  progress;
    TextView howFinish;
    Button finish;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
  resultTitle=findViewById(R.id.result_text_title);
  resultCategory=findViewById(R.id.result_category);
  resulDiff=findViewById(R.id.result_diff);




    }
}