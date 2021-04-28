package com.dicoding.akromatopsia.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity.TvshowEntity

interface MovieCatalogueDataSource {

    fun getAllMovies(): LiveData<List<MovieEntity>>

    fun getAllTvshows(): LiveData<List<TvshowEntity>>

}