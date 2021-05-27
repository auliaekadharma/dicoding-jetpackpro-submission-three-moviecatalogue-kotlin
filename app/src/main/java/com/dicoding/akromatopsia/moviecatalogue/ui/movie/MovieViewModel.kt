package com.dicoding.akromatopsia.moviecatalogue.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.akromatopsia.moviecatalogue.data.MovieCatalogueRepository
import com.dicoding.akromatopsia.moviecatalogue.vo.Resource

class MovieViewModel (private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {

    fun getMovies(): LiveData<Resource<PagedList<MovieEntity>>> = movieCatalogueRepository.getAllMovies()

}