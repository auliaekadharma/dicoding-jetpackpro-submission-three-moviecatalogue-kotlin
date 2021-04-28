package com.dicoding.akromatopsia.moviecatalogue.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieResponse(
    var movieId: String,
    var title: String,
    var year: String,
    var releaseDate: String,
    var genres: String,
    var duration: String,
    var description: String,
    var poster: String,
) : Parcelable

