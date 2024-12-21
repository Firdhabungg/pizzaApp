package com.example.pizzaapp.client

import com.example.pizzaapp.response.FoodResponse
import com.example.pizzaapp.response.account.LoginResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {
//    request get data menu (food)
    @GET("Food")
    fun getFood(): Call<ArrayList<FoodResponse>>

    @FormUrlEncoded
    @POST("Account")
    fun postLogin(
        @Field("username") username: String,
        @Field("password") password: String
        ): Call<LoginResponse>

}