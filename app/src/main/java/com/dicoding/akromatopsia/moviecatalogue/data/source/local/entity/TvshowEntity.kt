package com.dicoding.akromatopsia.moviecatalogue.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tvshowentities")
data class TvshowEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "tvshowId")
    var tvshowId: String,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "year")
    var year: String,

    @ColumnInfo(name = "genres")
    var genres: String,

    @ColumnInfo(name = "duration")
    var duration: String,

    @ColumnInfo(name = "description")
    var description: String,

    @ColumnInfo(name = "poster")
    var poster: String,

    @ColumnInfo(name = "favorite")
    var favorite: Boolean = false,
)
