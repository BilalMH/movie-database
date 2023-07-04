package me.bilalhaider.moviedatabase.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.engine.okhttp.OkHttpEngine
import me.bilalhaider.moviedatabase.network.mobileapi.MovieRepository
import me.bilalhaider.moviedatabase.network.mobileapi.SearchRepository
import me.bilalhaider.moviedatabase.network.mobileapi.client.MobileAPIClient
import me.bilalhaider.moviedatabase.network.mobileapi.client.createHttpClient

/**
 * Created by Bilal Haider on 17/03/2022
 */
@InstallIn(SingletonComponent::class)
@Module
object MobileAPIModule {

    @Provides
    fun mobileAPIClient(
        @ApplicationContext application: Context
    ) = MobileAPIClient(
        createHttpClient(OkHttp.create())
    )

    @Provides
    fun movieRepository(
        mobileAPIClient: MobileAPIClient
    ) = MovieRepository(
        mobileAPIClient
    )

    @Provides
    fun searchRepository(
        mobileAPIClient: MobileAPIClient
    ) = SearchRepository(
        mobileAPIClient
    )
}