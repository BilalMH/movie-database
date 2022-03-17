package me.bilalhaider.moviedatabase.ui.movie;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.bilalhaider.moviedatabase.R;
import me.bilalhaider.moviedatabase.data.model.MovieResponse;
import me.bilalhaider.moviedatabase.util.CommonFunctions;

public class MovieActivity extends AppCompatActivity implements MovieContract.View {

    MoviePresenter moviePresenter = new MoviePresenter();
    String imdbID;

    @BindView(R.id.parentMovieConstraintLayout)
    ConstraintLayout parentMovieConstraintLayout;
    @BindView(R.id.movieTitle)
    TextView movieTitleTV;
    @BindView(R.id.genreTV)
    TextView genreTV;
    @BindView(R.id.plotTV)
    TextView plotTV;
    @BindView(R.id.directorTV)
    TextView directorTV;
    @BindView(R.id.actorsTV)
    TextView actorsTV;
    @BindView(R.id.yearOfProduction)
    TextView yearOfProductionTV;
    @BindView(R.id.moviePoster)
    ImageView moviePosterIV;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        ButterKnife.bind(this);
        moviePresenter.attachView(this);
        getLifecycle().addObserver(moviePresenter);
        initResources();
    }

    @Override
    public void initResources() {
        if (getIntent().hasExtra("IMDBID")) {
            imdbID = getIntent().getStringExtra("IMDBID");
        }

        moviePresenter.getMovieByID(imdbID);
    }

    @Override
    public Boolean isNetworkAvailable() {
        return CommonFunctions.isNetworkAvailable(this);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void handleOnResponseSuccess(MovieResponse movieResponse) {
        if (movieResponse != null) {
            movieTitleTV.setText(movieResponse.getTitle());
            genreTV.setText(movieResponse.getGenre());
            plotTV.setText(movieResponse.getPlot());
            directorTV.setText(movieResponse.getDirector());
            actorsTV.setText(movieResponse.getActors());
            yearOfProductionTV.setText(movieResponse.getYear());

            if (!movieResponse.getPoster().equals("")) {
                Glide.with(this)
                        .load(movieResponse.getPoster())
                        .fitCenter()
                        .into(moviePosterIV);
            }
        }
    }

    @Override
    public void handleOnErrorResponse(String errorMessage) {
        CommonFunctions.showSnackbar(parentMovieConstraintLayout, errorMessage);

    }
}
