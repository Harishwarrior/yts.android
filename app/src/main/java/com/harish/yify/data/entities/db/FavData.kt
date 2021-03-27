package com.harish.yify.data.entities.db

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.harish.yify.data.Constants.FAV_TABLE
import com.harish.yify.data.entities.yify.movies.MovieItemSchema

@Entity(tableName = FAV_TABLE)
data class FavData(
        @NonNull @PrimaryKey val id: String,
         val movie: MovieItemSchema? = null)