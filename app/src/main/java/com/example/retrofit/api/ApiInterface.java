package com.example.retrofit.api;

import com.example.retrofit.model.Department;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("getDepartment.php")
    Call<List<Department>> getDepartment();
}
