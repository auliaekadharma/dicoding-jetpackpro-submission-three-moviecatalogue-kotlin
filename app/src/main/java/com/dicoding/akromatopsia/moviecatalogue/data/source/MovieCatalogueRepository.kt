package com.dicoding.akromatopsia.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity.TvshowEntity
import com.dicoding.akromatopsia.moviecatalogue.data.source.remote.RemoteDataSource
import com.dicoding.akromatopsia.moviecatalogue.data.source.remote.response.MovieResponse
import com.dicoding.akromatopsia.moviecatalogue.data.source.remote.response.TvshowResponse

class MovieCatalogueRepository private constructor(private val remoteDataSource: RemoteDataSource) : MovieCatalogueDataSource {

    companion object {
        @Volatile
        private var instance: MovieCatalogueRepository? = null
        fun getInstance(remoteData: RemoteDataSource): MovieCatalogueRepository =
            instance ?: synchronized(this) {
                instance ?: MovieCatalogueRepository(remoteData)
            }
    }

    override fun getAllMovies(): LiveData<List<MovieEntity>> {
        val movieResults = MutableLiveData<List<MovieEntity>>()
        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMoviesReceived(movieResponses: List<MovieResponse>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in movieResponses) {
                    val movie = MovieEntity(
                        response.movieId,
                        response.title,
                        response.year,
                        response.releaseDate,
                        response.genres,
                        response.duration,
                        response.description,
                        response.poster
                    )
                    movieList.add(movie)
                }
                movieResults.postValue(movieList)
            }
        })

        return movieResults
    }

    override fun getAllTvshows(): LiveData<List<TvshowEntity>> {
        val tvshowResults = MutableLiveData<List<TvshowEntity>>()
        remoteDataSource.getAllTvshows(object : RemoteDataSource.LoadTvshowsCallback {
            override fun onAllTvshowsReceived(tvshowResponses: List<TvshowResponse>) {
                val tvshowList = ArrayList<TvshowEntity>()
                for (response in tvshowResponses) {
                    val tvshow = TvshowEntity(
                        response.tvshowId,
                        response.title,
                        response.year,
                        response.genres,
                        response.duration,
                        response.description,
                        response.poster)
                    tvshowList.add(tvshow)
                }
                tvshowResults.postValue(tvshowList)
            }
        })

        return tvshowResults
    }

}