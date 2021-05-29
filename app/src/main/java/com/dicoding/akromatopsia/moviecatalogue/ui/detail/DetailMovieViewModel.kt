package com.dicoding.akromatopsia.moviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.dicoding.akromatopsia.moviecatalogue.data.MovieCatalogueRepository
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity.MovieEntity

class DetailMovieViewModel (private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {
    val movieId = MutableLiveData<String>()

    var movie: LiveData<MovieEntity> = Transformations.switchMap(movieId) {
        movieCatalogueRepository.getMovie(it)
    }

    fun setSelectedMovie(movieId: String) {
        this.movieId.value = movieId
    }


    fun setFavoriteMovie() {
        val movieEntity = movie.value
        if (movieEntity != null) {
            val newState = !movieEntity.favorite
            movieCatalogueRepository.setMovieFavorite(movieEntity, newState)
        }
    }

}
