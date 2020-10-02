package com.service;

import android.util.Log;
import com.example.models.QuizResponse;




import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class QuizApiClient implements  QuizApiCallback  {

Retrofit retrofit=new Retrofit
        .Builder()
        .baseUrl("https://opentdb.com/")
        .addConverterFactory(GsonConverterFactory
        .create())
        .build();







QuizApi client=retrofit.create(QuizApi.class);


    @Override
    public void getQuestions(int amount, int category, String difficulty, QuestionCallback questionCallback) {

        Call <QuizResponse>call=client.getQuestions(amount, category, difficulty);


        call.enqueue(new Callback<QuizResponse>() {
            @Override
            public void onResponse(Call<QuizResponse> call, Response<QuizResponse> response) {

                if (response.body()!=null){

                questionCallback.onSuccess((QuizResponse) response.body().getResults());


                } else




                {

                    questionCallback.onFailure(new Exception("Response is Empty"+response.code()));

                    assert response.body() != null;
                    questionCallback.onSuccess((QuizResponse) response.body().getResults());



                }


            }

            @Override
            public void onFailure(Call<QuizResponse> call, Throwable t) {


                questionCallback.onFailure(new Exception(t.getMessage()));

            }
        });






    }




    public interface  QuizApi{
   @GET("api.php")
  public   Call<QuizResponse> getQuestions(


           @Query("amount") int amount,

           @Query("category") int category,

           @Query("difficulty") String difficulty);





}



}
