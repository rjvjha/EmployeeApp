package com.rjvjha.android.employee.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.jetbrains.annotations.NotNull

@Entity(tableName = "employee")
data class Employee(

    @PrimaryKey(autoGenerate = true)
    @NotNull
    @Expose
    @SerializedName("id")
    var id:Int,

    @ColumnInfo(name = "email")
    @NotNull
    @Expose
    @SerializedName("email")
    var email: String,

    @ColumnInfo(name = "first_name")
    @NotNull
    @Expose
    @SerializedName("first_name")
    var firstName: String,

    @ColumnInfo(name = "last_name")
    @Expose
    @SerializedName("last_name")
    var lastName: String,

    @ColumnInfo(name = "avatar_url")
    @Expose
    @SerializedName("avatar")
    var avatar:String

)