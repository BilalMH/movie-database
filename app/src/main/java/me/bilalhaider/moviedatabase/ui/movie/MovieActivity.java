package me.bilalhaider.moviedatabase.ui.movie;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import me.bilalhaider.moviedatabase.R;
import me.bilalhaider.moviedatabase.data.model.MovieResponse;
import me.bilalhaider.moviedatabase.util.CommonFunctions;

public class MovieActivity extends AppCompatActivity implements MovieContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public Boolean isNetworkAvailable() {
        return CommonFunctions.isNetworkAvailable(this);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void handleOnResponseSuccess(MovieResponse movieResponse) {

    }

    @Override
    public void handleOnErrorResponse(String errorMessage) {

    }
}
