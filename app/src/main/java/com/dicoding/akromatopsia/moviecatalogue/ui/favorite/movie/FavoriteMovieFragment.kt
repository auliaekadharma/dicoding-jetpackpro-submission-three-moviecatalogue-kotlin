package com.dicoding.akromatopsia.moviecatalogue.ui.favorite.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.akromatopsia.moviecatalogue.R
import com.dicoding.akromatopsia.moviecatalogue.databinding.FragmentFavoriteMovieBinding
import com.dicoding.akromatopsia.moviecatalogue.databinding.FragmentMovieBinding
import com.dicoding.akromatopsia.moviecatalogue.ui.movie.MovieAdapter
import com.dicoding.akromatopsia.moviecatalogue.ui.movie.MovieViewModel
import com.dicoding.akromatopsia.moviecatalogue.viewmodel.ViewModelFactory
import com.dicoding.akromatopsia.moviecatalogue.vo.Status

class FavoriteMovieFragment : Fragment() {

    private lateinit var fragmentFavoriteMovieBinding: FragmentFavoriteMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentFavoriteMovieBinding = FragmentFavoriteMovieBinding.inflate(inflater, container, false)
        return fragmentFavoriteMovieBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[FavoriteMovieViewModel::class.java]

            val favMovieAdapter = FavoriteMovieAdapter()

            fragmentFavoriteMovieBinding.progressBar.visibility = View.VISIBLE

            viewModel.getFavoriteMovies().observe(viewLifecycleOwner, { movies ->
                fragmentFavoriteMovieBinding.progressBar.visibility = View.GONE
//                favMovieAdapter.setMovies(movies)
//                favMovieAdapter.notifyDataSetChanged()
                favMovieAdapter.submitList(movies)
            })

            with(fragmentFavoriteMovieBinding.rvFavMovie) {
                this?.layoutManager = LinearLayoutManager(context)
                this?.setHasFixedSize(true)
                this?.adapter = favMovieAdapter
            }
        }

    }


}