package com.dicoding.akromatopsia.moviecatalogue.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity.TvshowEntity
import com.dicoding.akromatopsia.moviecatalogue.data.MovieCatalogueRepository
import com.dicoding.akromatopsia.moviecatalogue.utils.DataDummy
import com.dicoding.akromatopsia.moviecatalogue.vo.Resource
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
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
    private lateinit var observer: Observer<Resource<PagedList<TvshowEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<TvshowEntity>

    @Before
    fun setUp() {
        viewModel = TvshowViewModel(movieCatalogueRepository)
    }

    @Test
    fun getTvshows() {
        val dummyTvshows = Resource.success(pagedList)
        `when`(dummyTvshows.data?.size).thenReturn(10)
        val tvshows = MutableLiveData<Resource<PagedList<TvshowEntity>>>()
        tvshows.value = dummyTvshows

        Mockito.`when`(movieCatalogueRepository.getAllTvshows()).thenReturn(tvshows)
        val tvshowEntities = viewModel.getTvshows().value?.data
        verify(movieCatalogueRepository).getAllTvshows()
        Assert.assertNotNull(tvshowEntities)
        Assert.assertEquals(10, tvshowEntities?.size)

        viewModel.getTvshows().observeForever(observer)
        verify(observer).onChanged(dummyTvshows)
    }
}