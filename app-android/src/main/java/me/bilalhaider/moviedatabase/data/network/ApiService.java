package me.bilalhaider.moviedatabase.data.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import me.bilalhaider.moviedatabase.util.Constants;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiService {

    private static OkHttpClient.Builder mHttpClientBuilder = new OkHttpClient.Builder();
    private static Gson mGson = new GsonBuilder().create();

    private static Retrofit.Builder mRetrofitBuilder =
            new Retrofit.Builder()
            .baseUrl("http://www.omdbapi.com/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(mGson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {

        mHttpClientBuilder
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS);

        mHttpClientBuilder.addInterceptor((Interceptor) chain -> {
            Request original = chain.request();
            HttpUrl originalHttpUrl = original.url();

            Request.Builder requestBuilder = original.newBuilder()
                    .url(original.url())
                    .method(original.method(), original.body());

            Request newRequest = requestBuilder.build();
            return chain.proceed(newRequest);

        });

        OkHttpClient client = mHttpClientBuilder.build();
        Retrofit retrofit = mRetrofitBuilder.client(client).build();
        return retrofit.create(serviceClass);
    }

}
