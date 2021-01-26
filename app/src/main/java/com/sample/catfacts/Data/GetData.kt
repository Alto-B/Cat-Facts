package com.sample.catfacts.Data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GetData {

    private val baseURL:String = "https://catfact.ninja/"

    fun create(): JsonApiCaller{
        val retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(JsonApiCaller::class.java)
    }

}

