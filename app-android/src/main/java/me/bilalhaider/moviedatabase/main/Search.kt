package me.bilalhaider.moviedatabase.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import me.bilalhaider.moviedatabase.network.model.SearchResult
import java.util.Locale

/**
 * Created by Bilal Haider on 18/03/2022
 */
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Search(
    onSearchResultClickCallback: (String) -> Unit
) {

    val mainActivityViewModel: MainActivityViewModel = viewModel()
    val textState = remember { mutableStateOf(TextFieldValue()) }
    val searchResults = mainActivityViewModel.searchResults.collectAsState()
    val searchResultsCount = mainActivityViewModel.searchResultCount.collectAsState()
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words),
                label = { Text("Search for a movie") },
                modifier = Modifier.wrapContentHeight(),
                singleLine = true,
                value = textState.value,
                onValueChange = {
                    textState.value = it
                }
            )

            Button(
                modifier = Modifier
                    .height(48.dp)
                    .padding(start = 5.dp),
                onClick = {
                    mainActivityViewModel.fetchSearchResults(textState.value.text)
                    keyboardController?.hide()
                }
            ) {
                Text(text = "Search")
            }
        }

        LazyColumn {
            if (searchResults.value.isNotEmpty()) {
                item {
                    Text(
                        modifier = Modifier
                            .weight(1f)
                            .padding(all = 16.dp),
                        text = "${searchResultsCount.value} results",
                        fontSize = 16.sp
                    )
                }

                items(items = searchResults.value) {
                    SearchResultItem(searchResult = it, onSearchResultClickCallback)
                }
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
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(
                start = 20.dp,
                end = 20.dp,
                top = 24.dp,
                bottom = 24.dp
            )
            .clickable { onSearchResultClickCallback(searchResult.imdbID) }
    ) {
        Column(modifier = Modifier
            .weight(1f)
            .padding(end = 12.dp)
        ) {
            Text(
                text = searchResult.title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                modifier = Modifier.padding(top = 5.dp),
                text = searchResult.searchResultSubTitle(),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        }

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
                    .height(120.dp)
                    .width(88.dp)
            )
        }

    }
}

@Composable
@Preview
fun SearchComposablePreview() {
    MaterialTheme {
        Search { }
    }
}
