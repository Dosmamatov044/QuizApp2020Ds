package com.service;

import com.example.models.QuizResponse;

public interface QuizApiCallback {

    void  getQuestions(int amount,int category,String difficulty,QuestionCallback questionCallback);

    interface QuestionCallback {
        void onSuccess(QuizResponse response);

        void onFailure(Throwable e);
    }

}
