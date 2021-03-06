package com.example.retrofit.activity.editor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.retrofit.R;
import com.example.retrofit.api.ApiInterface;
import com.thebluealliance.spectrum.SpectrumPalette;

public class EditorActivity extends AppCompatActivity implements EditorView {

    EditText et_title, et_note;
    ProgressDialog progressDialog;
    SpectrumPalette palette;

    ApiInterface apiInterface;

    EditorPresenter presenter;

    int color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_editor );

        et_title = findViewById(R.id.title);
        et_note = findViewById(R.id.note);
        palette = findViewById( R.id.palette );

        palette.setOnColorSelectedListener(
                clr -> color = clr
        );

        //Default Color Setup
        palette.setSelectedColor( getResources().getColor( R.color.white ) );
        color = getResources().getColor( R.color.white );

        //Progress Dialog
        progressDialog = new ProgressDialog( this );
        progressDialog.setMessage("Please wait...");

        presenter = new EditorPresenter( this );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate( R.menu.menu_editor, menu );
        return super.onCreateOptionsMenu( menu );
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save:
                //Save
                String title = et_title.getText().toString().trim();
                String note = et_note.getText().toString().trim();
                int color = this.color;

                if (title.isEmpty()) {
                    et_title.setError( "Please enter a title" );
                } else if (note.isEmpty()) {
                    et_note.setError( "Please enter a note" );
                } else {
                    presenter.saveNote( title, note, color );
                }
                return true;
            default:
                return super.onOptionsItemSelected( item );
        }
    }

    @Override
    public void showProgress() {
        progressDialog.show();
    }

    @Override
    public void hideProgress() {
        progressDialog.hide();
    }

    @Override
    public void onAddSuccess(String message) {
        Toast.makeText( EditorActivity.this, message,
                Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onAddError(String message) {
        Toast.makeText( EditorActivity.this, message,
                Toast.LENGTH_SHORT).show();
    }
}
