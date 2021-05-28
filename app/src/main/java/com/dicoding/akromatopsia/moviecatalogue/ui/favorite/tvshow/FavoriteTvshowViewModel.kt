package com.dicoding.akromatopsia.moviecatalogue.ui.favorite.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.akromatopsia.moviecatalogue.data.MovieCatalogueRepository
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity.TvshowEntity

class FavoriteTvshowViewModel (private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {

    fun getFavoriteTvshows(): LiveData<PagedList<TvshowEntity>> = movieCatalogueRepository.getFavoriteTvshows()

    fun setFavoriteTvshow(tvshowEntity: TvshowEntity) {
        val newState = !tvshowEntity.favorite
        movieCatalogueRepository.setTvshowFavorite(tvshowEntity, newState)
    }
}