package com.dicoding.akromatopsia.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.LocalDataSource
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity.TvshowEntity
import com.dicoding.akromatopsia.moviecatalogue.data.source.remote.ApiResponse
import com.dicoding.akromatopsia.moviecatalogue.data.source.remote.RemoteDataSource
import com.dicoding.akromatopsia.moviecatalogue.data.source.remote.response.MovieResponse
import com.dicoding.akromatopsia.moviecatalogue.data.source.remote.response.TvshowResponse
import com.dicoding.akromatopsia.moviecatalogue.utils.AppExecutors
import com.dicoding.akromatopsia.moviecatalogue.vo.Resource

class MovieCatalogueRepository private constructor(
        private val remoteDataSource: RemoteDataSource,
        private val localDataSource: LocalDataSource,
        private val appExecutors: AppExecutors)
    : MovieCatalogueDataSource {

    companion object {
        @Volatile
        private var instance: MovieCatalogueRepository? = null
        fun getInstance(remoteData: RemoteDataSource, localData: LocalDataSource, appExecutors: AppExecutors): MovieCatalogueRepository =
            instance ?: synchronized(this) {
                instance ?: MovieCatalogueRepository(remoteData, localData, appExecutors).apply {
                    instance = this
                }
            }
    }

    override fun getAllMovies(): LiveData<Resource<List<MovieEntity>>> {
        return object : NetworkBoundResource<List<MovieEntity>, List<MovieResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<List<MovieEntity>> =
                localDataSource.getAllMovies()

            override fun shouldFetch(data: List<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllMovies()

            public override fun saveCallResult(movieResponses: List<MovieResponse>) {
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
                        response.poster,
                    false)
                    movieList.add(movie)
                }

                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()
    }

    override fun getAllTvshows(): LiveData<Resource<List<TvshowEntity>>> {
        return object : NetworkBoundResource<List<TvshowEntity>, List<TvshowResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<List<TvshowEntity>> =
                localDataSource.getAllTvshows()

            override fun shouldFetch(data: List<TvshowEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<TvshowResponse>>> =
                remoteDataSource.getAllTvshows()

            public override fun saveCallResult(tvshowResponses: List<TvshowResponse>) {
                val tvshowList = ArrayList<TvshowEntity>()
                for (response in tvshowResponses) {
                    val tvshow = TvshowEntity(
                        response.tvshowId,
                        response.title,
                        response.year,
                        response.genres,
                        response.duration,
                        response.description,
                        response.poster,
                    false)
                    tvshowList.add(tvshow)
                }

                localDataSource.insertTvshows(tvshowList)
            }
        }.asLiveData()
    }

    override fun getMovie(movieId: String): LiveData<MovieEntity> = localDataSource.getMovie(movieId)

    override fun getTvshow(tvshowId: String): LiveData<TvshowEntity> = localDataSource.getTvshow(tvshowId)

    override fun getFavoriteMovies(): LiveData<List<MovieEntity>> =
        localDataSource.getFavoriteMovies()

    override fun getFavoriteTvshows(): LiveData<List<TvshowEntity>> =
        localDataSource.getFavoriteTvshows()

    override fun setMovieFavorite(movie: MovieEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setMovieFavorite(movie, state) }

    override fun setTvshowFavorite(tvshow: TvshowEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setTvshowFavorite(tvshow, state) }

}