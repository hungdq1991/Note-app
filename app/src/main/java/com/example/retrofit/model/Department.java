package com.example.retrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Department {

    @Expose
    @SerializedName( "department_code" ) private String department_code;
    @Expose
    @SerializedName( "department_name" ) private String department_name;

    public String getDepartment_code() {
        return department_code;
    }

    public void setDepartment_code(String department_code) {
        this.department_code = department_code;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }
}
