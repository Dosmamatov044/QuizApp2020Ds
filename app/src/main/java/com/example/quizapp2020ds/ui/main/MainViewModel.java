package com.example.quizapp2020ds.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {


    //public MutableLiveData<String> mResult = new MutableLiveData();
    public MutableLiveData<Integer> mResult = new MutableLiveData();

   /* public void test(){
        String result;
        int firstNumber =1;
        int secondNumber =1;

        result = String.valueOf(firstNumber + secondNumber);

        mResult.setValue(result);


        mResult.postValue(result);}*/


public  void plus(){
    if(mResult.getValue()==null){
        mResult.setValue(0);
    }
mResult.setValue(mResult.getValue()+1);


}
public void minus(){
   if (mResult.getValue()==null){

       mResult.setValue(0);

   }

    mResult.setValue(mResult.getValue()-1);

}

}