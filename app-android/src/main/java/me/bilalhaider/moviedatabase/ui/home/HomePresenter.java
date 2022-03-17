package me.bilalhaider.moviedatabase.ui.home;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import me.bilalhaider.moviedatabase.MovieDatabaseApplication;
import me.bilalhaider.moviedatabase.data.model.SearchResponse;
import me.bilalhaider.moviedatabase.ui.base.BasePresenter;
import me.bilalhaider.moviedatabase.util.Constants;

public class HomePresenter extends BasePresenter<HomeContract.View> implements HomeContract.Presenter {

    @Override
    public void searchMovie(String searchQuery) {
        if (mCurrentView != null) {
            if (mCurrentView.isNetworkAvailable()) {
                mCurrentView.showProgress();
                Single<SearchResponse> searchMovies = MovieDatabaseApplication.getApiService().getSearchResults(searchQuery, Constants.apiKey);
                SearchResultObserver searchResultObserver = new SearchResultObserver();
                searchMovies.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(searchResultObserver);
            } else {
                mCurrentView.handleOnErrorResponse("");
            }
        }

    }

    class SearchResultObserver extends DisposableSingleObserver<SearchResponse> {

        @Override
        public void onSuccess(SearchResponse value) {
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
