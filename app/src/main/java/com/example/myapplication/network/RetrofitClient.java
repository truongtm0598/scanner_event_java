package com.example.myapplication.network;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit = null;
    private static final String BASE_URL = "https://event2024.kienlongbank.com/";
    private static final String API_KEY = "4f720dd0a13aec6b440d18531dc5e8e0";

    public static Retrofit getClient(){
        if(retrofit == null){
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(chain -> {
                Request original = chain.request();
                Request request = original.newBuilder().header("X-Api-key", API_KEY).method(original.method(), original.body()).build();
                return chain.proceed(request);
            });
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(httpClient.build()).build();
        }
        return retrofit;
    }

}