package com.dicoding.akromatopsia.moviecatalogue.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity.TvshowEntity

@Dao
interface MovieCatalogueDao {

    @Query("SELECT * FROM movieentities")
    fun getMovies(): LiveData<List<MovieEntity>>

    @Query("SELECT * FROM movieentities WHERE movieId = :movieId")
    fun getMovie(movieId: String): LiveData<MovieEntity>

    @Query("SELECT * FROM movieentities WHERE favorite = 1")
    fun getFavoriteMovie(): LiveData<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MovieEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)



    @Query("SELECT * FROM tvshowentities")
    fun getTvshows(): LiveData<List<TvshowEntity>>

    @Query("SELECT * FROM tvshowentities WHERE tvshowId = :tvshowId")
    fun getTvshow(tvshowId: String): LiveData<TvshowEntity>

    @Query("SELECT * FROM tvshowentities WHERE favorite = 1")
    fun getFavoriteTvshow(): LiveData<List<TvshowEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvshows(tvshows: List<TvshowEntity>)

    @Update
    fun updateTvshow(tvshow: TvshowEntity)
}