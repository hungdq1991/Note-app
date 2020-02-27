package com.example.retrofit.activity.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.retrofit.R;
import com.example.retrofit.activity.editor.EditorActivity;
import com.example.retrofit.model.Department;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView{

    FloatingActionButton fab;
    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;

    MainPresenter mainPresenter;
    MainAdapter mainAdapter;
    MainAdapter.ItemClickListener itemClickListener;
    List<Department> departmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        swipeRefreshLayout = findViewById( R.id.swipe_refresh );
        recyclerView = findViewById( R.id.recycler_view );
        recyclerView.setLayoutManager( new LinearLayoutManager( this ) );

        fab = findViewById( R.id.add );
        fab.setOnClickListener( view -> {
            startActivity( new Intent( this, EditorActivity.class ) );
        } );

        mainPresenter = new MainPresenter( this );
        mainPresenter.getData();

        swipeRefreshLayout.setOnRefreshListener(
                () -> mainPresenter.getData()
        );

        itemClickListener = ((view, position) -> {
            String title = departmentList.get( position ).getDepartment_code();
            Toast.makeText( this, title, Toast.LENGTH_SHORT ).show();
        });
    }

    @Override
    public void showLoading() {
        swipeRefreshLayout.setRefreshing( true );
    }

    @Override
    public void hideLoading() {
        swipeRefreshLayout.setRefreshing( false );
    }

    @Override
    public void onGetResult(List<Department> notes) {
        mainAdapter = new MainAdapter( this, notes, itemClickListener );
        mainAdapter.notifyDataSetChanged();
        recyclerView.setAdapter( mainAdapter );

        departmentList = notes;
    }

    @Override
    public void onErrorLoading(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
