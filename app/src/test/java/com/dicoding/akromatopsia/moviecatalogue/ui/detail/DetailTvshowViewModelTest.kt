package com.dicoding.akromatopsia.moviecatalogue.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.akromatopsia.moviecatalogue.data.MovieCatalogueRepository
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity.TvshowEntity
import com.dicoding.akromatopsia.moviecatalogue.utils.DataDummy
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
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
    private lateinit var observer: Observer<TvshowEntity>

    @Before
    fun setUp() {
        viewModel = DetailTvshowViewModel(movieCatalogueRepository)
        viewModel.setSelectedTvshow(tvshowId)
    }


    @Test
    fun getTvshow() {
        val tvshow = MutableLiveData<TvshowEntity>()
        tvshow.value = dummyTvshow

        `when`(movieCatalogueRepository.getTvshow(tvshowId)).thenReturn(tvshow)

        viewModel.tvshow.observeForever(observer)

        verify(observer).onChanged(dummyTvshow)

    }
}