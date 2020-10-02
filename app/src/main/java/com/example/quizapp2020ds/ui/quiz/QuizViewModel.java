package com.example.quizapp2020ds.ui.quiz;





import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import java.util.ArrayList;
import java.util.List;



public class QuizViewModel extends ViewModel {



    MutableLiveData<List<Question>> questions = new MutableLiveData<>();
    MutableLiveData<Integer> currentQuestionPosition = new MutableLiveData<>();
    private List<Question> mQuestions=new ArrayList<>();






QuestionsForRepository questionsForRepository=new QuestionsForRepository();







public QuizViewModel() {

       currentQuestionPosition.setValue(0);
    }



    public void getQuestion(){
        mQuestions.add(new Question(new String[]{"a", "b", "c", "d"}, "какой выберешь?", "a", Type.CHOISE_FROM_FOUR));
        mQuestions.add(new Question(new String[]{"a", "b", "c", "d"}, "какой выберешь?", "b", Type.CHOISE_FROM_FOUR));
        mQuestions.add(new Question(new String[]{"a", "b", "c", "d"}, "какой выберешь?", "a", Type.CHOISE_FROM_FOUR));
        mQuestions.add(new Question(new String[]{"a", "b", "c", "d"}, "какой выберешь?", "c", Type.CHOISE_FROM_FOUR));
        mQuestions.add(new Question(new String[]{"a", "b", "c", "d"}, "какой выберешь?", "a", Type.CHOISE_FROM_FOUR));
        mQuestions.add(new Question(new String[]{"True", "False"}, "Правда или ложь?", "True", Type.TRUE_OR_FALSE));
        mQuestions.add(new Question(new String[]{"True", "False"}, "Правда или ложь?", "True", Type.TRUE_OR_FALSE));
        mQuestions.add(new Question(new String[]{"False", "True"}, "Правда или ложь?", "True", Type.TRUE_OR_FALSE));
        mQuestions.add(new Question(new String[]{"True", "False"}, "Правда или ложь?", "True", Type.TRUE_OR_FALSE));
        mQuestions.add(new Question(new String[]{"False", "True"}, "Правда или ложь?", "True", Type.TRUE_OR_FALSE));

        questions.setValue(mQuestions);
    }




    void  onSkipClick(){
        Integer currentPosition = currentQuestionPosition.getValue();
        if (currentPosition != null) {
            onAnswerClick(currentPosition, -1);
        }
    }




    void onBackpessed(){
        if (mQuestions.size()!=0){

            currentQuestionPosition.setValue(currentQuestionPosition.getValue() - 1);





        }


    }

    public int onAnswerClick(int position, int selectAnswerPosition) {


        if (mQuestions.size() >= position && position >= 0) {

            currentQuestionPosition.setValue(currentQuestionPosition.getValue() + 1);

            questions.setValue(mQuestions);


        }


   return  position;

    }














    }

















