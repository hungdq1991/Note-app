package com.example.retrofit.activity.main;

import com.example.retrofit.model.Department;

import java.util.List;

public interface MainView {
    void showLoading();
    void hideLoading();
    void onGetResult(List<Department> notes);
    void onErrorLoading(String message);
}
