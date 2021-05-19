package com.dicoding.akromatopsia.moviecatalogue.ui.favorite.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.akromatopsia.moviecatalogue.data.MovieCatalogueRepository
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity.MovieEntity

class FavoriteMovieViewModel (private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {

    fun getFavoriteMovies(): LiveData<List<MovieEntity>> = movieCatalogueRepository.getFavoriteMovies()
}