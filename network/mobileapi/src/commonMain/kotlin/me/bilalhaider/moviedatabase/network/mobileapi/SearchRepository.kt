package me.bilalhaider.moviedatabase.network.mobileapi

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import me.bilalhaider.moviedatabase.network.mobileapi.client.MobileAPIClient
import me.bilalhaider.moviedatabase.network.mobileapi.client.endpoint.search
import me.bilalhaider.moviedatabase.network.mobileapi.client.use
import me.bilalhaider.moviedatabase.network.model.SearchResult

/**
 * Created by Bilal Haider on 17/03/2022
 */
class SearchRepository(
    private val mobileAPIClient: MobileAPIClient
) {

    private val _data = MutableStateFlow<List<SearchResult>>(emptyList())
    val data: StateFlow<List<SearchResult>> = _data

    private val _resultCount = MutableStateFlow("")
    val resultCount: StateFlow<String> = _resultCount

    suspend fun searchMovie(query: String) {
        mobileAPIClient.use {
            it.search(query)
        }?.let {
            _data.value = it.data
            _resultCount.value = it.totalResults
        }
    }

    suspend fun sortMoviesByTitleAscending() {
        _data.value = data.first().sortedBy { it.title }
    }

    suspend fun sortMoviesByTitleDescending() {
       _data.value = data.first().sortedByDescending { it.title }
    }

    suspend fun sortMoviesByYearAscending() {
        _data.value = data.first().sortedBy { it.year }
    }

    suspend fun sortMoviesByYearDescending() {
        _data.value = data.first().sortedByDescending { it.year }
    }


}