package com.harish.yify.data.entities.db

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.harish.yify.data.entities.FilterData
import com.harish.yify.data.entities.yify.movies.MovieItemSchema

@Entity(tableName = "movies")
data class MovieListData(@NonNull @PrimaryKey val type: String,
                         val currentPage: Int,
                          val movies: MutableList<MovieItemSchema>?,
                          val filters: FilterData?)