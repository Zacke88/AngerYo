package com.example.joakim.angeryo;

import java.util.List;

import retrofit.Call;
import retrofit.Response;
import retrofit.http.*;

/**
 * Created by Joakim on 2015-12-11.
 */
public interface MyAPI {
    @GET("/api/things/")
    Call<List<User>> getUser();

    @DELETE("/api/this/{name}")
    Call<Response> deletUser(@Path("name") String userName);

    @POST("/api/things")
    Call<User> createUser (@Body String name);
}
