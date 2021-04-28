package com.dicoding.akromatopsia.moviecatalogue.di

import android.content.Context
import com.dicoding.akromatopsia.moviecatalogue.data.source.MovieCatalogueRepository
import com.dicoding.akromatopsia.moviecatalogue.data.source.remote.RemoteDataSource
import com.dicoding.akromatopsia.moviecatalogue.utils.JsonHelper

object Injection {

    fun provideRepository(context: Context): MovieCatalogueRepository {

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))

        return MovieCatalogueRepository.getInstance(remoteDataSource)
    }

}