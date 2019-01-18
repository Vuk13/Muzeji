package com.example.win.muzeji;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    //@GET("retrofit/json_object.json")
    @GET("get_all.php")
    Call<MuzejList> getJSON();

    @GET("get_photos.php")
    Call<FotografijaList> getSlike();
}
