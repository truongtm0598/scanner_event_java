package com.example.myapplication.network;

import com.example.myapplication.models.AppRequestBody;
import com.example.myapplication.models.UserInfo;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @PUT("api/v1/Contact/{id}")
    Call<UserInfo> getInfoUser(
            @Path("id") String id,
            @Body AppRequestBody appRequestBody
    );
}