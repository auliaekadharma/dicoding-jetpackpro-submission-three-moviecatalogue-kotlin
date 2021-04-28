package com.dicoding.akromatopsia.moviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.akromatopsia.moviecatalogue.data.source.MovieCatalogueRepository

class DetailMovieViewModel (private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {
    private lateinit var movieId: String

    fun setSelectedMovie(movieId: String) {
        this.movieId = movieId
    }

//    fun getMovie(): MovieEntity {
//        lateinit var movie: MovieEntity
//        val moviesEntities = movieCatalogueRepository.getAllMovies()
//        for (movieEntity in moviesEntities) {
//            if (movieEntity.movieId == movieId) {
//                movie = movieEntity
//            }
//        }
//        return movie
//    }

    fun getMovie() : LiveData<List<MovieEntity>> = movieCatalogueRepository.getAllMovies()

}
