package com.rjvjha.android.employee.data.remote.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.rjvjha.android.employee.data.model.Employee

data class EmployeeListResponse(

    @Expose
    @SerializedName("page")
    var page: Int,

    @Expose
    @SerializedName("per_page")
    var perPage: Int,

    @Expose
    @SerializedName("total")
    var total:Int,

    @Expose
    @SerializedName("total_pages")
    var totalPages:Int,

    @Expose
    @SerializedName("data")
    var data:List<Employee>
)