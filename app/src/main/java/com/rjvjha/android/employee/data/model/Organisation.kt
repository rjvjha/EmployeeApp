package com.rjvjha.android.employee.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Organisation(

    @Expose
    @SerializedName("company")
    var company:String,

    @Expose
    @SerializedName("url")
    var url: String,

    @Expose
    @SerializedName("text")
    var text:String
)