package com.dicoding.akromatopsia.moviecatalogue.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity.TvshowEntity
import com.dicoding.akromatopsia.moviecatalogue.data.source.MovieCatalogueRepository
import com.dicoding.akromatopsia.moviecatalogue.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailTvshowViewModelTest {

    private lateinit var viewModel: DetailTvshowViewModel
    private val dummyTvshow = DataDummy.generateDummyTvshow()[0]
    private val tvshowId = dummyTvshow.tvshowId


    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Mock
    private lateinit var tvshowObserver: Observer<List<TvshowEntity>>

    @Before
    fun setUp() {
        viewModel = DetailTvshowViewModel(movieCatalogueRepository)
        viewModel.setSelectedTvshow(tvshowId)
    }


    @Test
    fun getTvshow() {
        val tvshow = MutableLiveData<List<TvshowEntity>>()
        tvshow.value = listOf(dummyTvshow)

        `when`(movieCatalogueRepository.getAllTvshows()).thenReturn(tvshow)
        val tvshowEntity = viewModel.getTvshow().value
        Mockito.verify(movieCatalogueRepository).getAllTvshows()

        assertNotNull(tvshowEntity)
        assertEquals(dummyTvshow.tvshowId, tvshowEntity?.get(0)?.tvshowId)
        assertEquals(dummyTvshow.year, tvshowEntity?.get(0)?.year)
        assertEquals(dummyTvshow.genres, tvshowEntity?.get(0)?.genres)
        assertEquals(dummyTvshow.duration, tvshowEntity?.get(0)?.duration)
        assertEquals(dummyTvshow.description, tvshowEntity?.get(0)?.description)
        assertEquals(dummyTvshow.poster, tvshowEntity?.get(0)?.poster)
        assertEquals(dummyTvshow.title, tvshowEntity?.get(0)?.title)

        viewModel.getTvshow().observeForever(tvshowObserver)
        Mockito.verify(tvshowObserver).onChanged(listOf(dummyTvshow))
    }
}