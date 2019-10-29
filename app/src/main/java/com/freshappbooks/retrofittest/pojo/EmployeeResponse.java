package com.freshappbooks.retrofittest.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Response;

public class EmployeeResponse {

        @SerializedName("response")
        @Expose
        private List<Employee> response = null;

        public List<Employee> getResponse() {
            return response;
        }

        public void setResponse(List<Employee> response) {
            this.response = response;
        }

    }
