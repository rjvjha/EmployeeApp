package com.rjvjha.android.employee.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Employee(

    @Expose
    @SerializedName("id")
    var id:Int,

    @Expose
    @SerializedName("email")
    var email: String,

    @Expose
    @SerializedName("first_name")
    var firstName: String,

    @Expose
    @SerializedName("last_name")
    var lastName: String,

    @Expose
    @SerializedName("avatar")
    var avatar:String

)