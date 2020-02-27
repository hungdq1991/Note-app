package com.example.retrofit.activity.editor;

import androidx.annotation.NonNull;

import com.example.retrofit.api.ApiClient;
import com.example.retrofit.api.ApiInterface;
import com.example.retrofit.model.Department;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditorPresenter {

    private EditorView view;

    public EditorPresenter(EditorView view) {
        this.view = view;
    }

    void saveNote(final String title, final String note, final int color) {

//        view.showProgress();
//
//        ApiInterface apiInterface = ApiClient.getApiClient().create( ApiInterface.class);
//        Call<Department> call = apiInterface.saveNote( title, note, color );
//
//        call.enqueue( new Callback<Department>() {
//            @Override
//            public void onResponse(@NonNull Call<Department> call, @NonNull Response<Department> response) {
//                view.hideProgress();
//
//                if (response.isSuccessful() && response.body() != null) {
//                    Boolean success = response.body().getSuccess();
//                    if (success) {
//                        view.onAddSuccess( response.body().getMessage() );
//                    }
//                    else {
//                        view.onAddError( response.body().getMessage() );
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<Department> call, @NonNull Throwable t) {
//                view.hideProgress();
//                view.onAddError( t.getLocalizedMessage());
//            }
//        } );
    }

}
