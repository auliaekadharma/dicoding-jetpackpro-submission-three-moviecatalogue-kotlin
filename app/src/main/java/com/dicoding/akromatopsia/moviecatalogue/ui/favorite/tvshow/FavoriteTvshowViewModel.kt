package com.dicoding.akromatopsia.moviecatalogue.ui.favorite.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.akromatopsia.moviecatalogue.data.MovieCatalogueRepository
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity.TvshowEntity

class FavoriteTvshowViewModel (private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {

    fun getFavoriteTvshows(): LiveData<List<TvshowEntity>> = movieCatalogueRepository.getFavoriteTvshows()
}