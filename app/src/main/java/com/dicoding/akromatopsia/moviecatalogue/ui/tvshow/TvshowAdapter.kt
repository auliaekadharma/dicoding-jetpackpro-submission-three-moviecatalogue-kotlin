package com.dicoding.akromatopsia.moviecatalogue.ui.tvshow

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.akromatopsia.moviecatalogue.R
import com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity.TvshowEntity
import com.dicoding.akromatopsia.moviecatalogue.databinding.ItemsTvshowBinding
import com.dicoding.akromatopsia.moviecatalogue.ui.detail.DetailTvshowActivity


class TvshowAdapter(private val callback: TvshowFragmentCallback) : PagedListAdapter<TvshowEntity, TvshowAdapter.TvshowViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvshowEntity>() {
            override fun areItemsTheSame(oldItem: TvshowEntity, newItem: TvshowEntity): Boolean {
                return oldItem.tvshowId == newItem.tvshowId
            }

            override fun areContentsTheSame(oldItem: TvshowEntity, newItem: TvshowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvshowViewHolder {
        val itemsTvshowBinding = ItemsTvshowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvshowViewHolder(itemsTvshowBinding)
    }

    override fun onBindViewHolder(holder: TvshowViewHolder, position: Int) {
        val tvshow = getItem(position)
        if (tvshow != null) {
            holder.bind(tvshow)
        }
    }

    inner class TvshowViewHolder(private val binding: ItemsTvshowBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("StringFormatInvalid")
        fun bind(tvshow: TvshowEntity) {
            with(binding) {
                tvItemTitle.text = tvshow.title
                tvItemYear.text = tvshow.year
                tvItemGenre.text = tvshow.genres
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailTvshowActivity::class.java)
                    intent.putExtra(DetailTvshowActivity.EXTRA_TVSHOW, tvshow.tvshowId)
                    itemView.context.startActivity(intent)
                }
                imgShare.setOnClickListener { callback.onShareClick(tvshow) }
                Glide.with(itemView.context)
                        .load(tvshow.poster)
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                                .error(R.drawable.ic_error))
                        .into(imgPoster)
            }
        }

    }
}