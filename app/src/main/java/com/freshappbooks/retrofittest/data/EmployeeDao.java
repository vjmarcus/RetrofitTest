package com.freshappbooks.retrofittest.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.freshappbooks.retrofittest.pojo.Employee;

import java.util.List;

@Dao
public interface EmployeeDao {
    @Query("SELECT * FROM employees")
    LiveData<List<Employee>> getAllEmployees();

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insertEmployees(List<Employee> employees);

    @Query("DELETE FROM employees")
    void deleteAllEmployess();
}


