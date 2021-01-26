package com.sample.catfacts.Repository

import android.content.Context
import android.content.SharedPreferences
import com.sample.catfacts.Data.CatFact
import com.sample.catfacts.Data.GetData
import com.sample.catfacts.Data.JsonApiCaller
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Repository {
    private val SHARED_PREFS = "sharedPrefs"
    private val FACT = "fact"
    private lateinit var fact:String
    private var getData = GetData()

    fun getFactFromApi(context: Context){
        val jsonApiCaller = getData.create()
        val call = jsonApiCaller?.getFact()
        call?.enqueue(object : Callback<CatFact>{
            override fun onFailure(call: Call<CatFact>, t: Throwable) {

            }
            override fun onResponse(call: Call<CatFact>, response: Response<CatFact>) {
                if (response.isSuccessful){
                    val catFact = response.body()
                    val sharedPref: SharedPreferences = context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
                    val editor: SharedPreferences.Editor = sharedPref.edit()
                    editor.putString(FACT, catFact?.fact)
                    editor.apply()

                }
            }

        })
    }

    fun getFact(context: Context):String?{
        val sharedPref: SharedPreferences = context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
        val text = sharedPref.getString(FACT,"")
        return text

    }


}