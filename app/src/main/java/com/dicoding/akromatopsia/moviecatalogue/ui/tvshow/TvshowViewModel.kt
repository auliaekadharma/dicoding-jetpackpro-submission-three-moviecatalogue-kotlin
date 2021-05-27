package com.dicoding.akromatopsia.moviecatalogue.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity.TvshowEntity
import com.dicoding.akromatopsia.moviecatalogue.data.MovieCatalogueRepository
import com.dicoding.akromatopsia.moviecatalogue.vo.Resource

class TvshowViewModel (private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {

    fun getTvshows(): LiveData<Resource<PagedList<TvshowEntity>>> = movieCatalogueRepository.getAllTvshows()

}