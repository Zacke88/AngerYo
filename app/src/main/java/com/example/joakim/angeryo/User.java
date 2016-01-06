package com.example.joakim.angeryo;

import android.util.Log;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by Joakim on 2015-12-11.
 */
public class User {
    String name;

    public String toString() {
        return name;
    }

    public void retrocall() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://angularyo2.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MyAPI apiCall = retrofit.create(MyAPI.class);
        Call<List<User>> call = apiCall.getUser();
        //Call<Response> deleteCall = apiCall.deletUser("wzup");
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Response<List<User>> response, Retrofit retrofit) {
                Log.d("msg", response.body().toString());

            }

            @Override
            public void onFailure(Throwable t) {

            }

        });
    }
}