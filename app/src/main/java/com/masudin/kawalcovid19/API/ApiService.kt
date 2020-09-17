package com.masudin.kawalcovid19.API

import com.masudin.kawalcovid19.Model.Corona
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET(".")
    fun getCorona() : Call<Corona>
}