package com.dicoding.akromatopsia.moviecatalogue.ui.favorite.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.akromatopsia.moviecatalogue.R
import com.dicoding.akromatopsia.moviecatalogue.databinding.FragmentFavoriteTvshowBinding
import com.dicoding.akromatopsia.moviecatalogue.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar

class FavoriteTvshowFragment : Fragment() {

    private var fragmentFavoriteTvshowBinding: FragmentFavoriteTvshowBinding? = null
    private val binding get() = fragmentFavoriteTvshowBinding

    private lateinit var viewModel: FavoriteTvshowViewModel
    private lateinit var adapter: FavoriteTvshowAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentFavoriteTvshowBinding = FragmentFavoriteTvshowBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(binding?.rvFavTvshow)

        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[FavoriteTvshowViewModel::class.java]

            adapter = FavoriteTvshowAdapter()

            binding?.progressBar?.visibility = View.VISIBLE

            viewModel.getFavoriteTvshows().observe(viewLifecycleOwner, { tvshows ->
                binding?.progressBar?.visibility = View.GONE
                adapter.submitList(tvshows)
            })

            binding?.rvFavTvshow?.layoutManager = LinearLayoutManager(context)
            binding?.rvFavTvshow?.setHasFixedSize(true)
            binding?.rvFavTvshow?.adapter = adapter
        }
    }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder
        ): Int =
            makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipedPosition = viewHolder.adapterPosition
                val tvshowEntity = adapter.getSwipeData(swipedPosition)
                tvshowEntity?.let { viewModel.setFavoriteTvshow(it) }

                val snackbar = Snackbar.make(view as View, R.string.message_undo, Snackbar.LENGTH_LONG)
                snackbar.setAction(R.string.message_ok) { v ->
                    tvshowEntity?.let { viewModel.setFavoriteTvshow(it) }
                }
                snackbar.show()
            }
        }
    })
}