package com.dicoding.akromatopsia.moviecatalogue.data.source.local

import androidx.lifecycle.LiveData
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity.TvshowEntity
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.room.MovieCatalogueDao
import com.dicoding.akromatopsia.moviecatalogue.vo.Resource

class LocalDataSource private constructor(private val mMovieCatalogueDao: MovieCatalogueDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(movieCatalogueDao: MovieCatalogueDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(movieCatalogueDao)
    }

    fun getAllMovies(): LiveData<List<MovieEntity>> = mMovieCatalogueDao.getMovies()

    fun getMovie(movieId: String): LiveData<MovieEntity> = mMovieCatalogueDao.getMovie(movieId)

    fun getFavoriteMovies(): LiveData<List<MovieEntity>> = mMovieCatalogueDao.getFavoriteMovie()

    fun insertMovies(movies: List<MovieEntity>) = mMovieCatalogueDao.insertMovies(movies)

    fun setMovieFavorite(movie: MovieEntity, newState: Boolean) {
        movie.favorite = newState
        mMovieCatalogueDao.updateMovie(movie)
    }


    fun getAllTvshows(): LiveData<List<TvshowEntity>> = mMovieCatalogueDao.getTvshows()

    fun getTvshow(tvshowId: String): LiveData<TvshowEntity> = mMovieCatalogueDao.getTvshow(tvshowId)

    fun getFavoriteTvshows(): LiveData<List<TvshowEntity>> = mMovieCatalogueDao.getFavoriteTvshow()

    fun insertTvshows(tvshows: List<TvshowEntity>) = mMovieCatalogueDao.insertTvshows(tvshows)

    fun setTvshowFavorite(tvshow: TvshowEntity, newState: Boolean) {
        tvshow.favorite = newState
        mMovieCatalogueDao.updateTvshow(tvshow)
    }


}