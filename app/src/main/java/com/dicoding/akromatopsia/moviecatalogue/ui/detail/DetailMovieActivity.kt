package com.dicoding.akromatopsia.moviecatalogue.ui.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.dicoding.akromatopsia.moviecatalogue.R
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.akromatopsia.moviecatalogue.databinding.ActivityDetailMovieBinding
import com.dicoding.akromatopsia.moviecatalogue.databinding.ContentDetailMovieBinding
import com.dicoding.akromatopsia.moviecatalogue.viewmodel.ViewModelFactory

class DetailMovieActivity : AppCompatActivity() {

    private lateinit var detailContentBinding: ContentDetailMovieBinding

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailMovieBinding.detailContent

        setContentView(activityDetailMovieBinding.root)

        setSupportActionBar(activityDetailMovieBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailMovieViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)

            if (movieId != null) {
                activityDetailMovieBinding.progressBar.visibility = View.VISIBLE

                viewModel.setSelectedMovie(movieId)

                viewModel.getMovie().observe(this, { movie: List<MovieEntity> ->
                    activityDetailMovieBinding.progressBar.visibility = View.GONE
                    val id = movie.indexOfFirst{it.movieId == movieId}
                    populateMovie(movie[id])
                })
            }
        }
    }

    private fun populateMovie(movieEntity: MovieEntity) {
        detailContentBinding.textTitle.text = movieEntity.title
        detailContentBinding.textDescription.text = movieEntity.description
        detailContentBinding.textYear.text = movieEntity.year
        detailContentBinding.textDate.text = movieEntity.releaseDate
        detailContentBinding.textGenre.text = movieEntity.genres
        detailContentBinding.textDuration.text = movieEntity.duration

        Glide.with(this)
                .load(movieEntity.poster)
                .transform(RoundedCorners(20))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(detailContentBinding.imagePoster)
    }
}