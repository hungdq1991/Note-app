package com.example.retrofit.activity.main;

import androidx.annotation.NonNull;

import com.example.retrofit.api.ApiClient;
import com.example.retrofit.api.ApiInterface;
import com.example.retrofit.model.Department;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {

    private MainView view;

    public MainPresenter(MainView view) {
        this.view = view;
    }

    void getData() {
        view.showLoading();
        //Request to server
        ApiInterface apiInterface = ApiClient.getApiClient().create( ApiInterface.class );
        Call<List<Department>> call = apiInterface.getDepartment();
        call.enqueue( new Callback<List<Department>>() {
            @Override
            public void onResponse(@NonNull Call<List<Department>> call, @NonNull Response<List<Department>> response) {
                view.hideLoading();
                if (response.isSuccessful() && response.body() != null) {
                    view.onGetResult( response.body() );
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Department>> call, @NonNull Throwable t) {
                view.hideLoading();
                view.onErrorLoading( t.getLocalizedMessage() );
            }
        } );
    }
}
