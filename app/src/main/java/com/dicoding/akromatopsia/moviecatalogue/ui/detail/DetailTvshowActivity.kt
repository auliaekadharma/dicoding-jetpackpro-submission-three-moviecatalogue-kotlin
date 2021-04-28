package com.dicoding.akromatopsia.moviecatalogue.ui.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.dicoding.akromatopsia.moviecatalogue.R
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity.TvshowEntity
import com.dicoding.akromatopsia.moviecatalogue.databinding.ActivityDetailTvshowBinding
import com.dicoding.akromatopsia.moviecatalogue.databinding.ContentDetailTvshowBinding
import com.dicoding.akromatopsia.moviecatalogue.viewmodel.ViewModelFactory

class DetailTvshowActivity : AppCompatActivity() {

    private lateinit var detailContentBinding: ContentDetailTvshowBinding

    companion object {
        const val EXTRA_TVSHOW = "extra_tvshow"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailTvshowBinding = ActivityDetailTvshowBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailTvshowBinding.detailContent

        setContentView(activityDetailTvshowBinding.root)

        setSupportActionBar(activityDetailTvshowBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailTvshowViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val tvshowId = extras.getString(EXTRA_TVSHOW)

            if (tvshowId != null) {
                activityDetailTvshowBinding.progressBar.visibility = View.VISIBLE

                viewModel.setSelectedTvshow(tvshowId)

                viewModel.getTvshow().observe(this, { tvshow: List<TvshowEntity> ->
                    activityDetailTvshowBinding.progressBar.visibility = View.GONE
                    val id = tvshow.indexOfFirst{it.tvshowId == tvshowId}
                    populateTvshow(tvshow[id])

                })
            }
        }

    }

    private fun populateTvshow(tvshowEntity: TvshowEntity) {
        detailContentBinding.textTitle.text = tvshowEntity.title
        detailContentBinding.textDescription.text = tvshowEntity.description
        detailContentBinding.textYear.text = tvshowEntity.year
        detailContentBinding.textGenre.text = tvshowEntity.genres
        detailContentBinding.textDuration.text = tvshowEntity.duration

        Glide.with(this)
                .load(tvshowEntity.poster)
                .transform(RoundedCorners(20))
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                .into(detailContentBinding.imagePoster)
    }
}