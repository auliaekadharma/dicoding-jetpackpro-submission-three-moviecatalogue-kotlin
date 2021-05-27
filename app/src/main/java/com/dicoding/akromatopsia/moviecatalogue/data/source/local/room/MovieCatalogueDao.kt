package com.dicoding.akromatopsia.moviecatalogue.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity.TvshowEntity

@Dao
interface MovieCatalogueDao {

    @Query("SELECT * FROM movieentities")
    //fun getMovies(): LiveData<List<MovieEntity>>
    fun getMovies(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM movieentities WHERE movieId = :movieId")
    fun getMovie(movieId: String): LiveData<MovieEntity>

    @Query("SELECT * FROM movieentities WHERE favorite = 1")
    //fun getFavoriteMovie(): LiveData<List<MovieEntity>>
    fun getFavoriteMovie(): DataSource.Factory<Int, MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MovieEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)



    @Query("SELECT * FROM tvshowentities")
    //fun getTvshows(): LiveData<List<TvshowEntity>>
    fun getTvshows(): DataSource.Factory<Int, TvshowEntity>

    @Query("SELECT * FROM tvshowentities WHERE tvshowId = :tvshowId")
    fun getTvshow(tvshowId: String): LiveData<TvshowEntity>

    @Query("SELECT * FROM tvshowentities WHERE favorite = 1")
    //fun getFavoriteTvshow(): LiveData<List<TvshowEntity>>
    fun getFavoriteTvshow(): DataSource.Factory<Int, TvshowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvshows(tvshows: List<TvshowEntity>)

    @Update
    fun updateTvshow(tvshow: TvshowEntity)
}