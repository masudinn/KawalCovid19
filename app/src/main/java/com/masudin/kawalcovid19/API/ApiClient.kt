package com.masudin.kawalcovid19.API

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class ApiClient  {
    private val Base_Url : String = "https://api.kawalcorona.com/"


    private fun getInterceptor() : OkHttpClient{
        val loggingInterceptor = HttpLoggingInterceptor()
        //me log kesalahan server dan android
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    fun getRetrofit() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(Base_Url)
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun callService(){
        getRetrofit().create(ApiService::class.java)

    }
}