package me.bilalhaider.moviedatabase.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import me.bilalhaider.moviedatabase.network.model.SearchResult

/**
 * Created by Bilal Haider on 18/03/2022
 */
@Composable
fun Search(
    mainActivityViewModel: MainActivityViewModel = viewModel(),
    onSearchResultClickCallback: (String) -> Unit
) {
    val textState = remember { mutableStateOf(TextFieldValue()) }
    val searchResults = mainActivityViewModel.searchResults.collectAsState()

    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {

        Row {
            TextField(
                value = textState.value,
                onValueChange = {
                    textState.value = it
                }
            )

            Button(
                modifier = Modifier.height(40.dp),
                onClick = { mainActivityViewModel.fetchSearchResults(textState.value.text) }
            ) {
                Text(text = "Search")
            }
        }

        LazyColumn {
            items(items = searchResults.value) {

                SearchResultItem(searchResult = it, onSearchResultClickCallback)
            }
        }
    }
}

@Composable
fun SearchResultItem(
    searchResult: SearchResult,
    onSearchResultClickCallback: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, bottom = 24.dp)
            .clickable { onSearchResultClickCallback(searchResult.imdbID) }
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(end = 12.dp),
            text = searchResult.title,
        )

        Box(
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth()
                .clip(RoundedCornerShape(4.dp))
        ) {
            Image(
                painter = rememberImagePainter(
                    data = searchResult.poster),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(88.dp)
                    .width(88.dp)
            )
        }

    }
}
