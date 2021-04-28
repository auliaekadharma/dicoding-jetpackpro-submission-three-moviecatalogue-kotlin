package com.dicoding.akromatopsia.moviecatalogue.utils

import android.annotation.SuppressLint
import android.content.Context
import com.dicoding.akromatopsia.moviecatalogue.data.source.remote.response.MovieResponse
import com.dicoding.akromatopsia.moviecatalogue.data.source.remote.response.TvshowResponse
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException

class JsonHelper(private val context: Context) {

    private fun parsingFileToString(fileName: String): String? {
        return try {
            val `is` = context.assets.open(fileName)
            val buffer = ByteArray(`is`.available())
            `is`.read(buffer)
            `is`.close()
            String(buffer)

        } catch (ex: IOException) {
            ex.printStackTrace()
            null
        }
    }

    @Suppress("DEPRECATION")
    @SuppressLint("UseCompatLoadingForDrawables")
    fun loadMovies(): List<MovieResponse> {
        val list = ArrayList<MovieResponse>()
        val resources = context.resources
        try {
            val responseObject = JSONObject(parsingFileToString("MovieResponses.json").toString())
            val listArray = responseObject.getJSONArray("movies")
            for (i in 0 until listArray.length()) {
                val movie = listArray.getJSONObject(i)

                val movieId = movie.getString("movieId")
                val title = movie.getString("title")
                val year = movie.getString("year")
                val releaseDate = movie.getString("releaseDate")
                val genres = movie.getString("genres")
                val duration = movie.getString("duration")
                val description = movie.getString("description")
                val poster = movie.getString("poster")

                val movieResponse = MovieResponse(movieId, title, year, releaseDate, genres, duration, description, poster)
                list.add(movieResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }

    fun loadTvshows(): List<TvshowResponse> {
        val list = ArrayList<TvshowResponse>()
        try {
            val responseObject = JSONObject(parsingFileToString("TvshowResponses.json").toString())
            val listArray = responseObject.getJSONArray("tvshows")
            for (i in 0 until listArray.length()) {
                val tvshow = listArray.getJSONObject(i)

                val tvshowId = tvshow.getString("tvshowId")
                val title = tvshow.getString("title")
                val year = tvshow.getString("year")
                val genres = tvshow.getString("genres")
                val duration = tvshow.getString("duration")
                val description = tvshow.getString("description")
                val poster = tvshow.getString("poster")

                val tvshowResponse = TvshowResponse(tvshowId, title, year, genres, duration, description, poster)
                list.add(tvshowResponse)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return list
    }

}