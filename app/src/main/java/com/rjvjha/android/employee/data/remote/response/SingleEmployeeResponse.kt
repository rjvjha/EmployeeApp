package com.rjvjha.android.employee.data.remote.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.rjvjha.android.employee.data.model.Employee
import com.rjvjha.android.employee.data.model.Organisation

data class SingleEmployeeResponse(
    @Expose
    @SerializedName("data")
    var data: Employee,

    @Expose
    @SerializedName("ad")
    var ad: Organisation

)