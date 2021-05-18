package com.dicoding.akromatopsia.moviecatalogue.data

import androidx.lifecycle.LiveData
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity.TvshowEntity
import com.dicoding.akromatopsia.moviecatalogue.vo.Resource

interface MovieCatalogueDataSource {

    fun getAllMovies(): LiveData<Resource<List<MovieEntity>>>

    fun getMovie(movieId: String): LiveData<MovieEntity>

    fun getFavoriteMovies(): LiveData<List<MovieEntity>>

    fun setMovieFavorite(movie: MovieEntity, state: Boolean)



    fun getAllTvshows(): LiveData<Resource<List<TvshowEntity>>>

    fun getTvshow(tvshowId: String): LiveData<TvshowEntity>

    fun getFavoriteTvshows(): LiveData<List<TvshowEntity>>

    fun setTvshowFavorite(tvshow: TvshowEntity, state: Boolean)

}