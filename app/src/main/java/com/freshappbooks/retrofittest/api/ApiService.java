package com.freshappbooks.retrofittest.api;

import com.freshappbooks.retrofittest.pojo.EmployeeResponse;

import retrofit2.http.GET;
import io.reactivex.Observable;

public interface ApiService {
    @GET ("testTask.json")
    Observable <EmployeeResponse> getEmployees();
}
