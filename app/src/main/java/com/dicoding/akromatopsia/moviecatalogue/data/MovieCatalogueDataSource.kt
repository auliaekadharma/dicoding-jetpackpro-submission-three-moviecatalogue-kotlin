package com.dicoding.akromatopsia.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity.TvshowEntity
import com.dicoding.akromatopsia.moviecatalogue.vo.Resource

interface MovieCatalogueDataSource {

    fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getMovie(movieId: String): LiveData<MovieEntity>

    fun getFavoriteMovies(): LiveData<PagedList<MovieEntity>>

    fun setMovieFavorite(movie: MovieEntity, state: Boolean)



    fun getAllTvshows(): LiveData<Resource<PagedList<TvshowEntity>>>

    fun getTvshow(tvshowId: String): LiveData<TvshowEntity>

    fun getFavoriteTvshows(): LiveData<PagedList<TvshowEntity>>

    fun setTvshowFavorite(tvshow: TvshowEntity, state: Boolean)

}