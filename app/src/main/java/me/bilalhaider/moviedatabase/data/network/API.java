package me.bilalhaider.moviedatabase.data.network;

import io.reactivex.Single;
import me.bilalhaider.moviedatabase.data.model.SearchResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {

    @GET("?type=movie")
    Single<SearchResponse> getSearchResults(
            @Query("s") String searchString
    );

    @GET("?plot=full")
    Single<SearchResponse> getMovieByID(
            @Query("i") String imdbID
    );

}
