package me.bilalhaider.moviedatabase.ui.movie;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import me.bilalhaider.moviedatabase.MovieDatabaseApplication;
import me.bilalhaider.moviedatabase.data.model.MovieResponse;
import me.bilalhaider.moviedatabase.ui.base.BasePresenter;
import me.bilalhaider.moviedatabase.util.Constants;

public class MoviePresenter extends BasePresenter<MovieContract.View> implements MovieContract.Presenter {

    @Override
    public void getMovieByID(String imdbID) {
        if (mCurrentView != null) {
            if (mCurrentView.isNetworkAvailable()) {
                mCurrentView.showProgress();
                Single<MovieResponse> searchMovies = MovieDatabaseApplication.getApiService().getMovieByID(imdbID, Constants.apiKey);
                MoviePresenter.MovieResponseObserver searchResultObserver = new MoviePresenter.MovieResponseObserver();
                searchMovies.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(searchResultObserver);
            } else {
                mCurrentView.handleOnErrorResponse("");
            }
        }

    }

    class MovieResponseObserver extends DisposableSingleObserver<MovieResponse> {

        @Override
        public void onSuccess(MovieResponse value) {
            if (mCurrentView != null) {
                mCurrentView.hideProgress();
                mCurrentView.handleOnResponseSuccess(value);
            }
        }

        @Override
        public void onError(Throwable e) {
            if (mCurrentView != null) {
                mCurrentView.hideProgress();
                mCurrentView.handleOnErrorResponse(e.getLocalizedMessage());
            }
        }
    }
}
