package me.bilalhaider.moviedatabase.ui.home;

import me.bilalhaider.moviedatabase.data.model.SearchResponse;
import me.bilalhaider.moviedatabase.ui.base.BaseView;

public interface HomeContract {

    interface View extends BaseView {
        Boolean isNetworkAvailable();
        void showProgress();
        void hideProgress();
        void handleOnResponseSuccess(SearchResponse searchResponse);
        void handleOnErrorResponse(String errorMessage);
    }

    interface Presenter {
        void searchMovie(String searchQuery);
    }

}
