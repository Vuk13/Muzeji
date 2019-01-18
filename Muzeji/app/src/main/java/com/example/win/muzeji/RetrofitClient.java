package com.example.win.muzeji;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    //public static final String ROOT_URL = "http://api.androiddeft.com/";
    public static final String ROOT_URL = "http://10.0.3.2/administracija_baze/";
    private static Retrofit getRetrofitInstance(){
        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
  public static ApiService getApiService(){
        return getRetrofitInstance().create(ApiService.class);
  }
}
