package com.example.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public  class Question {

    @SerializedName("category")
    @Expose
    private String category;

    @SerializedName("type")
    @Expose
      private  String type;

    @SerializedName("difficulty")
    @Expose
    private String difficulty;
    @SerializedName("question")
    @Expose
    private String question;
    @SerializedName("correct_answer")
    @Expose
    private String correctAnswer;
    @SerializedName("incorrect_answers")
   @Expose

    private List<String> incorrect;

    @SerializedName("answers")
    private List<String> answers;
    private int selectAnswerPosition;

    private boolean isAnswered;



    public Question(String category, String difficulty, String question, String correctAnswer, List<String> incorrect, List<String> answers, int selectAnswerPosition, boolean isAnswered) {
        this.category = category;
        this.difficulty = difficulty;
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.incorrect = incorrect;
        this.answers = answers;
        this.selectAnswerPosition = selectAnswerPosition;
        this.isAnswered = isAnswered;

    }

    public boolean isAnswered() {
        return isAnswered;
    }

    public void setAnswered(boolean answered) {
        isAnswered = answered;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public int getSelectAnswerPosition() {
        return selectAnswerPosition;
    }

    public void setSelectAnswerPosition(int selectAnswerPosition) {
        this.selectAnswerPosition = selectAnswerPosition;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }



    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public List<String> getIncorrect() {
        return incorrect;
    }

    public void setIncorrect(List<String> incorrect) {
        this.incorrect = incorrect;
    }
}
