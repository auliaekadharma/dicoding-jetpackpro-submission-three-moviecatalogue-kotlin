package com.dicoding.akromatopsia.moviecatalogue.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvshowResponse(
    var tvshowId: String,
    var title: String,
    var year: String,
    var genres: String,
    var duration: String,
    var description: String,
    var poster: String,
) : Parcelable
