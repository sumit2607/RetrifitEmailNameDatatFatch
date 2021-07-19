package com.example.july16we;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Apiservice {

    @GET("/comments")
    Call<List<ResponseModel>> getpost(@Query("postId") int postId);
}
