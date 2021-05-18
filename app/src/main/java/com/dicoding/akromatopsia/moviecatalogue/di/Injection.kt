package com.dicoding.akromatopsia.moviecatalogue.di

import android.content.Context
import com.dicoding.akromatopsia.moviecatalogue.data.MovieCatalogueRepository
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.LocalDataSource
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.room.MovieCatalogueDatabase
import com.dicoding.akromatopsia.moviecatalogue.data.source.remote.RemoteDataSource
import com.dicoding.akromatopsia.moviecatalogue.utils.AppExecutors
import com.dicoding.akromatopsia.moviecatalogue.utils.JsonHelper

object Injection {

    fun provideRepository(context: Context): MovieCatalogueRepository {

        val database = MovieCatalogueDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(JsonHelper(context))
        val localDataSource = LocalDataSource.getInstance(database.movieCatalogueDao())
        val appExecutors = AppExecutors()

        return MovieCatalogueRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }

}