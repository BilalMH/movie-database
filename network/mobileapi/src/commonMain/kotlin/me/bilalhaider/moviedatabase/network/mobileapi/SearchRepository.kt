package me.bilalhaider.moviedatabase.network.mobileapi

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
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

    suspend fun searchMovie(query: String) {
        mobileAPIClient.use {
            it.search(query)
        }?.let {
            _data.value = it.data
        }
    }


}