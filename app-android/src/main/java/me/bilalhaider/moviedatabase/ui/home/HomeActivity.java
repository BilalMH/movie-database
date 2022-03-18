package me.bilalhaider.moviedatabase.ui.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.bilalhaider.moviedatabase.R;
import me.bilalhaider.moviedatabase.data.model.SearchResponse;
import me.bilalhaider.moviedatabase.util.CommonFunctions;

public class HomeActivity extends AppCompatActivity implements HomeContract.View {

//    @BindView(R.id.movieListRecyclerView)
    RecyclerView movieListRV;
//    @BindView(R.id.progressBar)
    ProgressBar progressBar;
//    @BindView(R.id.searchMovieEditText)
    AppCompatEditText searchMovieEditText;
//    @BindView(R.id.parentConstraintLayout)
    ConstraintLayout parentConstraintLayout;

    HomePresenter homePresenter = new HomePresenter();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        homePresenter.attachView(this);
        getLifecycle().addObserver(homePresenter);
        initResources();
    }

    private void initResources() {
        movieListRV = findViewById(R.id.movieListRecyclerView);
        progressBar = findViewById(R.id.progressBar);
        searchMovieEditText = findViewById(R.id.searchMovieEditText);
        parentConstraintLayout = findViewById(R.id.parentConstraintLayout);

        movieListRV.setLayoutManager(new LinearLayoutManager(this));

        searchMovieEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (searchMovieEditText.getText() != null &&
                        searchMovieEditText.getText().toString().length() > 0) {
                    homePresenter.searchMovie(searchMovieEditText.getText().toString());
                } else {
                    movieListRV.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
        
    }

    @Override
    public Boolean isNetworkAvailable() {
        return CommonFunctions.isNetworkAvailable(this);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        movieListRV.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
        movieListRV.setVisibility(View.VISIBLE);
    }

    @Override
    public void handleOnResponseSuccess(SearchResponse searchResponse) {
        if (searchResponse.getSearch() != null) {
            HomeAdapter homeAdapter = new HomeAdapter(this, searchResponse.getSearch());
            movieListRV.setAdapter(homeAdapter);
        }
    }

    @Override
    public void handleOnErrorResponse(String errorMessage) {
        CommonFunctions.showSnackbar(parentConstraintLayout, errorMessage);
    }
}
