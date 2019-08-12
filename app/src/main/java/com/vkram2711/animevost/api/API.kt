package com.vkram2711.animevost.api

import com.vkram2711.animevost.Constants
import com.vkram2711.animevost.pojo.Ongoing
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface API{

    @GET("/v1/last")
    suspend fun getOngoings(@Query("page") page: Int,
                    @Query("quantity") quantity: Int = 15): Response<Ongoing>


    companion object Factory{
        fun create() = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build().create(API::class.java)!!
    }
}