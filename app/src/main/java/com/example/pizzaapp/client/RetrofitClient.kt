package com.example.pizzaapp.client

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    const val BASE_URL = "http://192.168.123.37/rest_api3055/index.php/"
    val url = "http://192.168.254.60/rest_api3055/gambar/"

val instance:Api by lazy {
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    retrofit.create(Api::class.java)
    }
}