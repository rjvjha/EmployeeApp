package com.rjvjha.android.employee.data.local.db.dao

import androidx.room.*
import com.rjvjha.android.employee.data.model.Employee
import io.reactivex.Single

@Dao
interface EmployeeDao {

    @Insert
    fun insert(employee: Employee) : Single<Long>

    @Update
    fun update(employee: Employee) : Single<Int>

    @Delete
    fun delete(employee: Employee) : Single<Int>

    @Insert
    fun insertMany(empList: List<Employee>) : Single<List<Long>>

    @Query("SELECT * FROM employee")
    fun getAllEmployees() : Single<List<Employee>>

    @Query("SELECT * FROM employee WHERE id = :id LIMIT 1")
    fun getEmployeeById(id : Long) : Single<Employee>

    @Query("SELECT count(*) FROM employee")
    fun count() : Single<Int>

    @Query("Delete FROM employee")
    fun deleteAllEmployees() : Single<Int>

}