package com.dicoding.akromatopsia.moviecatalogue.ui.detail

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
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

    private lateinit var activityDetailTvshowBinding: ActivityDetailTvshowBinding
    private lateinit var detailContentBinding: ContentDetailTvshowBinding

    private lateinit var viewModel: DetailTvshowViewModel
    private var menu: Menu? = null

    companion object {
        const val EXTRA_TVSHOW = "extra_tvshow"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityDetailTvshowBinding = ActivityDetailTvshowBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailTvshowBinding.detailContent

        setContentView(activityDetailTvshowBinding.root)

        setSupportActionBar(activityDetailTvshowBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailTvshowViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val tvshowId = extras.getString(EXTRA_TVSHOW)

            if (tvshowId != null) {
                viewModel.setSelectedTvshow(tvshowId)

                viewModel.tvshow.observe(this, Observer {
                    if (it != null) {
                        populateTvshow(it)
                    }
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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        this.menu = menu
        viewModel.tvshow.observe(this, Observer {
            if (it != null) {
                val state = it.favorite
                setFavoriteState(state)
            }
        })

        return true
    }

    private fun setFavoriteState(state: Boolean) {
        if (menu == null) return

        val menuItem = menu?.findItem(R.id.action_favorite)

        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite_filled)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_favorite) {
            viewModel.setFavoriteTvshow()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}