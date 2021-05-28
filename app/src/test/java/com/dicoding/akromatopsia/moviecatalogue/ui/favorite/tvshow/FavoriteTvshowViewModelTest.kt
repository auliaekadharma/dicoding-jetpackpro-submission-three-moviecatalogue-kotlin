package com.dicoding.akromatopsia.moviecatalogue.ui.favorite.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dicoding.akromatopsia.moviecatalogue.data.MovieCatalogueRepository
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity.TvshowEntity
import com.dicoding.akromatopsia.moviecatalogue.ui.favorite.movie.FavoriteMovieViewModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteTvshowViewModelTest {

    private lateinit var viewModel: FavoriteTvshowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Mock
    private lateinit var observer: Observer<PagedList<TvshowEntity>>

    @Mock
    private lateinit var pagedList: PagedList<TvshowEntity>

    @Before
    fun setUp() {
        viewModel = FavoriteTvshowViewModel(movieCatalogueRepository)
    }

    @Test
    fun getFavoriteTvshows() {
        val dummyTvshows = pagedList
        Mockito.`when`(dummyTvshows.size).thenReturn(10)
        val tvshows = MutableLiveData<PagedList<TvshowEntity>>()
        tvshows.value = dummyTvshows

        Mockito.`when`(movieCatalogueRepository.getFavoriteTvshows()).thenReturn(tvshows)
        val tvshowEntities = viewModel.getFavoriteTvshows().value
        Mockito.verify(movieCatalogueRepository).getFavoriteTvshows()
        assertNotNull(tvshowEntities)
        assertEquals(10, tvshowEntities?.size)

        viewModel.getFavoriteTvshows().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyTvshows)
    }
}