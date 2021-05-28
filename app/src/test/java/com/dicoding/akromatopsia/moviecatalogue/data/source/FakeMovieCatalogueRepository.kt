package com.dicoding.akromatopsia.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.dicoding.akromatopsia.moviecatalogue.data.MovieCatalogueDataSource
import com.dicoding.akromatopsia.moviecatalogue.data.MovieCatalogueRepository
import com.dicoding.akromatopsia.moviecatalogue.data.NetworkBoundResource
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.LocalDataSource
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity.TvshowEntity
import com.dicoding.akromatopsia.moviecatalogue.data.source.remote.ApiResponse
import com.dicoding.akromatopsia.moviecatalogue.data.source.remote.RemoteDataSource
import com.dicoding.akromatopsia.moviecatalogue.data.source.remote.response.MovieResponse
import com.dicoding.akromatopsia.moviecatalogue.data.source.remote.response.TvshowResponse
import com.dicoding.akromatopsia.moviecatalogue.utils.AppExecutors
import com.dicoding.akromatopsia.moviecatalogue.vo.Resource

class FakeMovieCatalogueRepository constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors)
    : MovieCatalogueDataSource {

        override fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>> {
            return object : NetworkBoundResource<PagedList<MovieEntity>, List<MovieResponse>>(appExecutors) {
                public override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                    val config = PagedList.Config.Builder()
                        .setEnablePlaceholders(false)
                        .setInitialLoadSizeHint(4)
                        .setPageSize(4)
                        .build()
                    return LivePagedListBuilder(localDataSource.getAllMovies(), config).build()
                }

                override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
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

        override fun getAllTvshows(): LiveData<Resource<PagedList<TvshowEntity>>> {
            return object : NetworkBoundResource<PagedList<TvshowEntity>, List<TvshowResponse>>(appExecutors) {
                public override fun loadFromDB(): LiveData<PagedList<TvshowEntity>> {
                    val config = PagedList.Config.Builder()
                        .setEnablePlaceholders(false)
                        .setInitialLoadSizeHint(4)
                        .setPageSize(4)
                        .build()
                    return LivePagedListBuilder(localDataSource.getAllTvshows(), config).build()
                }

                override fun shouldFetch(data: PagedList<TvshowEntity>?): Boolean =
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

        override fun getFavoriteMovies(): LiveData<PagedList<MovieEntity>> {
            val config = PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(4)
                .setPageSize(4)
                .build()
            return LivePagedListBuilder(localDataSource.getFavoriteMovies(), config).build()
        }

        override fun getFavoriteTvshows(): LiveData<PagedList<TvshowEntity>> {
            val config = PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(4)
                .setPageSize(4)
                .build()
            return LivePagedListBuilder(localDataSource.getFavoriteTvshows(), config).build()
        }

        override fun setMovieFavorite(movie: MovieEntity, state: Boolean) =
            appExecutors.diskIO().execute { localDataSource.setMovieFavorite(movie, state) }

        override fun setTvshowFavorite(tvshow: TvshowEntity, state: Boolean) =
            appExecutors.diskIO().execute { localDataSource.setTvshowFavorite(tvshow, state) }
}