package com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity

data class MovieEntity(
    var movieId: String,
    var title: String,
    var year: String,
    var releaseDate: String,
    var genres: String,
    var duration: String,
    var description: String,
    var poster: String,
)
