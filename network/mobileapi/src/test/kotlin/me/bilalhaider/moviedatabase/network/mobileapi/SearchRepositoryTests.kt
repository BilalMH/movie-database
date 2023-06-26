package me.bilalhaider.moviedatabase.network.mobileapi

import com.google.common.truth.Truth.assertThat
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import kotlinx.coroutines.runBlocking
import me.bilalhaider.moviedatabase.network.mobileapi.client.MobileAPIClient
import me.bilalhaider.moviedatabase.network.mobileapi.mock.searchResponse
import org.junit.Before
import org.junit.Test
import org.koin.test.KoinTest

class SearchRepositoryTests : KoinTest {

    private lateinit var searchRepository: SearchRepository

    @Before
    fun setUp() {
        val engine = MockEngine {request ->
            respond(
                content = searchResponse,
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }

        searchRepository = SearchRepository(MobileAPIClient(engine))
    }

    @Test
    fun `check if search endpoint works and returns results`() = runBlocking {
        searchRepository.searchMovie("Batman")

        assert(searchRepository.data.value.isNotEmpty())
    }

    @Test
    fun `check if search endpoint returns empty results`() = runBlocking {
        searchRepository.searchMovie("")

        assert(searchRepository.data.value.isEmpty())
    }

    @Test
    fun `sort search results in alphabetical order ascending, correct order`() = runBlocking {
        searchRepository.searchMovie("Batman")
        searchRepository.sortMoviesByTitleAscending()
        val movies = searchRepository.data.value

        for(i in 0..movies.size - 2) {
            assertThat(movies[i].title).isLessThan(movies[i+1].title)
        }
    }

    @Test
    fun `sort search results in alphabetical order descending, correct order`() = runBlocking {
        searchRepository.searchMovie("Batman")
        searchRepository.sortMoviesByTitleDescending()
        val movies = searchRepository.data.value

        for(i in 0..movies.size - 2) {
            assertThat(movies[i].title).isGreaterThan(movies[i+1].title)
        }
    }

    @Test
    fun `sort search results in year of release order ascending, correct order`() = runBlocking {
        searchRepository.searchMovie("Batman")
        searchRepository.sortMoviesByYearAscending()
        val movies = searchRepository.data.value

        for(i in 0..movies.size - 2) {
            assertThat(movies[i].year).isAtMost(movies[i+1].year)
        }
    }

    @Test
    fun `sort search results in year of release order descending, correct order`() = runBlocking {
        searchRepository.searchMovie("Batman")
        searchRepository.sortMoviesByYearDescending()
        val movies = searchRepository.data.value

        for(i in 0..movies.size - 2) {
            assertThat(movies[i].year).isAtLeast(movies[i+1].year)
        }
    }
}