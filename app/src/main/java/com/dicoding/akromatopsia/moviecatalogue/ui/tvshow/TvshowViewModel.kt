package com.dicoding.akromatopsia.moviecatalogue.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity.TvshowEntity
import com.dicoding.akromatopsia.moviecatalogue.data.source.MovieCatalogueRepository

class TvshowViewModel (private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {

    fun getTvshows(): LiveData<List<TvshowEntity>> = movieCatalogueRepository.getAllTvshows()

}