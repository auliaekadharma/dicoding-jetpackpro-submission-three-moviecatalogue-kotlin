package com.dicoding.akromatopsia.moviecatalogue.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.LocalDataSource
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity.TvshowEntity
import com.dicoding.akromatopsia.moviecatalogue.data.source.remote.RemoteDataSource
import com.dicoding.akromatopsia.moviecatalogue.utils.AppExecutors
import com.dicoding.akromatopsia.moviecatalogue.utils.DataDummy
import com.dicoding.akromatopsia.moviecatalogue.utils.LiveDataTestUtil
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
        val dummyMovies = MutableLiveData<List<MovieEntity>>()
        dummyMovies.value = DataDummy.generateDummyMovies()
        `when`(local.getAllMovies()).thenReturn(dummyMovies)


        val movieEntities = LiveDataTestUtil.getValue(movieCatalogueRepository.getAllMovies())
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
        val dummyMovies = MutableLiveData<List<MovieEntity>>()
        dummyMovies.value = DataDummy.generateDummyMovies()
        `when`(local.getFavoriteMovies()).thenReturn(dummyMovies)

        val movieEntities = LiveDataTestUtil.getValue(movieCatalogueRepository.getFavoriteMovies())
        verify(local).getFavoriteMovies()
        assertNotNull(movieEntities)
        assertEquals(movieResponses.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getAllTvshows() {
        val dummyTvshow = MutableLiveData<List<TvshowEntity>>()
        dummyTvshow.value = DataDummy.generateDummyTvshow()
        `when`(local.getAllTvshows()).thenReturn(dummyTvshow)


        val tvshowEntities = LiveDataTestUtil.getValue(movieCatalogueRepository.getAllTvshows())
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
        val dummyTvshows = MutableLiveData<List<TvshowEntity>>()
        dummyTvshows.value = DataDummy.generateDummyTvshow()
        `when`(local.getFavoriteTvshows()).thenReturn(dummyTvshows)

        val tvshowEntities = LiveDataTestUtil.getValue(movieCatalogueRepository.getFavoriteTvshows())
        verify(local).getFavoriteTvshows()
        assertNotNull(tvshowEntities)
        assertEquals(tvshowResponses.size.toLong(), tvshowEntities.size.toLong())
    }
}