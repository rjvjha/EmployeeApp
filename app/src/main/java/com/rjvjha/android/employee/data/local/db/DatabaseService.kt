package com.rjvjha.android.employee.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rjvjha.android.employee.data.local.db.dao.EmployeeDao
import com.rjvjha.android.employee.data.model.Employee

@Database(entities = [Employee::class],
    version = 2,
    exportSchema = false
)
abstract class DatabaseService: RoomDatabase (){

    abstract fun employeeDao():EmployeeDao

}