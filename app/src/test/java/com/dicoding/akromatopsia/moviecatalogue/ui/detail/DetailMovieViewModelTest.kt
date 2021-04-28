package com.dicoding.akromatopsia.moviecatalogue.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.akromatopsia.moviecatalogue.data.source.MovieCatalogueRepository
import com.dicoding.akromatopsia.moviecatalogue.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {

    private lateinit var viewModel: DetailMovieViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val movieId = dummyMovie.movieId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Mock
    private lateinit var movieObserver: Observer<List<MovieEntity>>

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel(movieCatalogueRepository)
        viewModel.setSelectedMovie(movieId)
    }

    @Test
    fun getMovie() {
        val movie = MutableLiveData<List<MovieEntity>>()
        movie.value = listOf(dummyMovie)

        `when`(movieCatalogueRepository.getAllMovies()).thenReturn(movie)
        val movieEntity = viewModel.getMovie().value
        verify(movieCatalogueRepository).getAllMovies()

        assertNotNull(movieEntity)
        assertEquals(dummyMovie.movieId, movieEntity?.get(0)?.movieId)
        assertEquals(dummyMovie.year, movieEntity?.get(0)?.year)
        assertEquals(dummyMovie.releaseDate, movieEntity?.get(0)?.releaseDate)
        assertEquals(dummyMovie.genres, movieEntity?.get(0)?.genres)
        assertEquals(dummyMovie.duration, movieEntity?.get(0)?.duration)
        assertEquals(dummyMovie.description, movieEntity?.get(0)?.description)
        assertEquals(dummyMovie.poster, movieEntity?.get(0)?.poster)
        assertEquals(dummyMovie.title, movieEntity?.get(0)?.title)

        viewModel.getMovie().observeForever(movieObserver)
        verify(movieObserver).onChanged(listOf(dummyMovie))
    }
}