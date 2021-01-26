package com.sample.catfacts.Data

import com.google.gson.annotations.SerializedName

class CatFact {
    @SerializedName("fact")
    var fact:String? = null
    @SerializedName("length")
    var length:Int? = null


}