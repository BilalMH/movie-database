package me.bilalhaider.moviedatabase

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import me.bilalhaider.moviedatabase.data.network.API
import me.bilalhaider.moviedatabase.data.network.ApiService

@HiltAndroidApp
internal class MovieDatabaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }

    companion object {
        @JvmStatic
        val apiService: API
            get() = ApiService.createService(
                API::class.java)
    }
}