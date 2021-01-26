package com.sample.catfacts.ViewModel

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import com.sample.catfacts.Repository.Repository

class ViewModel:ViewModel() {

    private var repository: Repository
    private var fact:String? = null

    init {
        Log.i("Fact","ViewModel Made")
        repository = Repository()
    }

    fun updateText():String?{
        return fact
    }

    fun newFact(context: Context){
        repository.getFactFromApi(context)
        fact = repository.getFact(context)
    }

}