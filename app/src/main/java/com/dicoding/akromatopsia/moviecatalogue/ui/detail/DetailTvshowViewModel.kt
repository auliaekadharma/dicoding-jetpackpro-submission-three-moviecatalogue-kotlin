package com.dicoding.akromatopsia.moviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity.TvshowEntity
import com.dicoding.akromatopsia.moviecatalogue.data.MovieCatalogueRepository
import com.dicoding.akromatopsia.moviecatalogue.vo.Resource

class DetailTvshowViewModel (private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {
    val tvshowId = MutableLiveData<String>()

    var tvshow: LiveData<TvshowEntity> = Transformations.switchMap(tvshowId) {
        movieCatalogueRepository.getTvshow(it)
    }

    fun setSelectedTvshow(tvshowId: String) {
        this.tvshowId.value = tvshowId
    }

    fun setFavoriteTvshow() {
        val tvshowEntity = tvshow.value
        if (tvshowEntity != null) {
            val newState = !tvshowEntity.favorite
            movieCatalogueRepository.setTvshowFavorite(tvshowEntity, newState)
        }
    }


    //fun getTvshow() : LiveData<List<TvshowEntity>> = movieCatalogueRepository.getAllTvshows()
}