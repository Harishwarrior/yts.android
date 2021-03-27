package com.harish.yify.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.harish.yify.data.Constants.FAV_TABLE
import com.harish.yify.data.entities.db.FavData
import io.reactivex.Single

@Dao
interface FavsDao {
    @Query("SELECT * FROM $FAV_TABLE")
    fun fetchFavMovies(): Single<MutableList<FavData>>

    @Query("SELECT * FROM $FAV_TABLE WHERE id = :movieId")
    fun fetchFavMovie(movieId: String): Single<FavData>

    @Insert
    fun saveMovieToFav(data: FavData): Long

    @Delete
    fun unfavMovie(data: FavData): Int
}