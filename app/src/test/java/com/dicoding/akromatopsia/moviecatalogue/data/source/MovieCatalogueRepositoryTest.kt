package com.dicoding.akromatopsia.moviecatalogue.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.LocalDataSource
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity.TvshowEntity
import com.dicoding.akromatopsia.moviecatalogue.data.source.remote.RemoteDataSource
import com.dicoding.akromatopsia.moviecatalogue.utils.AppExecutors
import com.dicoding.akromatopsia.moviecatalogue.utils.DataDummy
import com.dicoding.akromatopsia.moviecatalogue.utils.LiveDataTestUtil
import com.dicoding.akromatopsia.moviecatalogue.utils.PagedListUtil
import com.dicoding.akromatopsia.moviecatalogue.vo.Resource
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class MovieCatalogueRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val movieCatalogueRepository = FakeMovieCatalogueRepository(remote, local, appExecutors)

    private val movieResponses = DataDummy.generateRemoteDummyMovies()
    private val movieId = movieResponses[0].movieId
    private val tvshowResponses = DataDummy.generateRemoteDummyTvshow()
    private val tvshowId = tvshowResponses[0].tvshowId

    @Test
    fun getAllMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovies()).thenReturn(dataSourceFactory)
        movieCatalogueRepository.getAllMovies()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getAllMovies()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getMovie() {
        val dummyMovie = MutableLiveData<MovieEntity>()
        dummyMovie.value = DataDummy.generateDummyMovies()[0]
        `when`(local.getMovie(movieId)).thenReturn(dummyMovie)

        val movieEntity = LiveDataTestUtil.getValue(movieCatalogueRepository.getMovie(movieId))
        verify(local).getMovie(movieId)
        assertNotNull(movieEntity)
        assertNotNull(movieEntity.title)
        assertEquals(movieResponses[0].title, movieEntity.title)

    }

    @Test
    fun getFavoriteMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getFavoriteMovies()).thenReturn(dataSourceFactory)
        movieCatalogueRepository.getFavoriteMovies()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getFavoriteMovies()
        assertNotNull(movieEntities)
        assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getAllTvshows() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvshowEntity>
        `when`(local.getAllTvshows()).thenReturn(dataSourceFactory)
        movieCatalogueRepository.getAllTvshows()

        val tvshowEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvshow()))
        verify(local).getAllTvshows()
        assertNotNull(tvshowEntities.data)
        assertEquals(tvshowResponses.size.toLong(), tvshowEntities.data?.size?.toLong())
    }

    @Test
    fun getTvshow() {
        val dummyTvshow = MutableLiveData<TvshowEntity>()
        dummyTvshow.value = DataDummy.generateDummyTvshow()[0]
        `when`(local.getTvshow(tvshowId)).thenReturn(dummyTvshow)

        val tvshowEntity = LiveDataTestUtil.getValue(movieCatalogueRepository.getTvshow(tvshowId))
        verify(local).getTvshow(tvshowId)
        assertNotNull(tvshowEntity)
        assertNotNull(tvshowEntity.title)
        assertEquals(tvshowResponses[0].title, tvshowEntity.title)

    }

    @Test
    fun getFavoriteTvshows() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvshowEntity>
        `when`(local.getFavoriteTvshows()).thenReturn(dataSourceFactory)
        movieCatalogueRepository.getFavoriteTvshows()

        val tvshowEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvshow()))
        verify(local).getFavoriteTvshows()
        assertNotNull(tvshowEntities)
        assertEquals(tvshowResponses.size.toLong(), tvshowEntities.data?.size?.toLong())
    }
}