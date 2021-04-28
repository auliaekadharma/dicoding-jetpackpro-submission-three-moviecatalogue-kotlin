package com.dicoding.akromatopsia.moviecatalogue.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity.TvshowEntity
import com.dicoding.akromatopsia.moviecatalogue.data.source.MovieCatalogueRepository
import com.dicoding.akromatopsia.moviecatalogue.utils.DataDummy
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvshowViewModelTest {

    private lateinit var viewModel: TvshowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Mock
    private lateinit var observer: Observer<List<TvshowEntity>>

    @Before
    fun setUp() {
        viewModel = TvshowViewModel(movieCatalogueRepository)
    }

    @Test
    fun getTvshows() {
        val dummyTvshows = DataDummy.generateDummyTvshow()
        val tvshows = MutableLiveData<List<TvshowEntity>>()
        tvshows.value = dummyTvshows

        Mockito.`when`(movieCatalogueRepository.getAllTvshows()).thenReturn(tvshows)
        val tvshowEntities = viewModel.getTvshows().value
        verify(movieCatalogueRepository).getAllTvshows()
        Assert.assertNotNull(tvshowEntities)
        Assert.assertEquals(10, tvshowEntities?.size)

        viewModel.getTvshows().observeForever(observer)
        verify(observer).onChanged(dummyTvshows)
    }
}