package com.pppb.travelindo;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface TravelAPI {

    @FormUrlEncoded
    @POST("authenticate")
    Call<User> logIn(
            @Field("username") String username,
            @Field("password") String password
    );
}
