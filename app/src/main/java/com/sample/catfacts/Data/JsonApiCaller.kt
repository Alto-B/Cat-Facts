package com.sample.catfacts.Data

import retrofit2.Call
import retrofit2.http.GET

interface JsonApiCaller {
    @GET("fact")
    fun getFact(): Call<CatFact>
}