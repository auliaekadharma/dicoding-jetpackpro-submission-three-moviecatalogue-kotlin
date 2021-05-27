package com.dicoding.akromatopsia.moviecatalogue.ui.favorite.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.akromatopsia.moviecatalogue.databinding.FragmentFavoriteTvshowBinding
import com.dicoding.akromatopsia.moviecatalogue.viewmodel.ViewModelFactory

class FavoriteTvshowFragment : Fragment() {

    private lateinit var fragmentFavoriteTvshowBinding: FragmentFavoriteTvshowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentFavoriteTvshowBinding = FragmentFavoriteTvshowBinding.inflate(inflater, container, false)
        return fragmentFavoriteTvshowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[FavoriteTvshowViewModel::class.java]

            val favTvshowAdapter = FavoriteTvshowAdapter()

            fragmentFavoriteTvshowBinding.progressBar.visibility = View.VISIBLE

            viewModel.getFavoriteTvshows().observe(viewLifecycleOwner, { tvshows ->
                fragmentFavoriteTvshowBinding.progressBar.visibility = View.GONE
//                favTvshowAdapter.setTvshows(tvshows)
//                favTvshowAdapter.notifyDataSetChanged()
                favTvshowAdapter.submitList(tvshows)
            })

            with(fragmentFavoriteTvshowBinding.rvFavTvshow) {
                this?.layoutManager = LinearLayoutManager(context)
                this?.setHasFixedSize(true)
                this?.adapter = favTvshowAdapter
            }
        }
    }
}