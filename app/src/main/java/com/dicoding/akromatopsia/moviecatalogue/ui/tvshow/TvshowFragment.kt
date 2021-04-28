package com.dicoding.akromatopsia.moviecatalogue.ui.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.akromatopsia.moviecatalogue.R
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity.TvshowEntity
import com.dicoding.akromatopsia.moviecatalogue.databinding.FragmentTvshowBinding
import com.dicoding.akromatopsia.moviecatalogue.viewmodel.ViewModelFactory

class TvshowFragment : Fragment(), TvshowFragmentCallback {

    lateinit var fragmentTvshowBinding: FragmentTvshowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentTvshowBinding = FragmentTvshowBinding.inflate(inflater, container, false)
        return fragmentTvshowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TvshowViewModel::class.java]

            val tvshowAdapter = TvshowAdapter(this)

            fragmentTvshowBinding.progressBar.visibility = View.VISIBLE
            viewModel.getTvshows().observe(viewLifecycleOwner, { tvshows ->
                fragmentTvshowBinding.progressBar.visibility = View.GONE
                tvshowAdapter.setTvshows(tvshows)
                tvshowAdapter.notifyDataSetChanged()
            })

            with(fragmentTvshowBinding.rvTvshow) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = tvshowAdapter
            }
        }
    }

    override fun onShareClick(tvshow: TvshowEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(requireActivity())
                .setType(mimeType)
                .setChooserTitle("Bagikan TV Show ini sekarang.")
                .setText(resources.getString(R.string.share_text, tvshow.title))
                .startChooser()
        }
    }

}