package me.bilalhaider.moviedatabase.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import me.bilalhaider.moviedatabase.network.mobileapi.SearchRepository
import me.bilalhaider.moviedatabase.network.model.SearchResult
import javax.inject.Inject

/**
 * Created by Bilal Haider on 18/03/2022
 */
@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val searchRepository: SearchRepository
) : ViewModel() {

    val searchResults: StateFlow<List<SearchResult>> = searchRepository.data

    fun fetchSearchResults(query: String) {
        viewModelScope.launch {
            try {
                searchRepository.searchMovie(query)
            } catch (e: Throwable) {
                Log.e("MainViewModel -> fetchSearch(): ", e.localizedMessage ?: "")
            }
        }
    }

}