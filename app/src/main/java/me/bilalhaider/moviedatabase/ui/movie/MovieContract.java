package me.bilalhaider.moviedatabase.ui.movie;

import me.bilalhaider.moviedatabase.data.model.MovieResponse;
import me.bilalhaider.moviedatabase.ui.base.BaseView;

public interface MovieContract {

    interface View extends BaseView {
        void initResources();
        Boolean isNetworkAvailable();
        void showProgress();
        void hideProgress();
        void handleOnResponseSuccess(MovieResponse movieResponse);
        void handleOnErrorResponse(String errorMessage);
    }

    interface Presenter {
        void getMovieByID(String imdbID);
    }
}
