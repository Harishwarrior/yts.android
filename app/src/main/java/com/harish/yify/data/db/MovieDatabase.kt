package com.harish.yify.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.harish.yify.data.db.converter.FilterModelConverter
import com.harish.yify.data.db.converter.MovieSchemaListTypeConverter
import com.harish.yify.data.db.converter.MovieSchemaTypeConverter
import com.harish.yify.data.entities.db.FavData
import com.harish.yify.data.entities.db.MovieListData

@Database(entities = [MovieListData::class, FavData::class], version = 1,  exportSchema = false)
@TypeConverters(MovieSchemaListTypeConverter::class, FilterModelConverter::class, MovieSchemaTypeConverter::class)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun moviesListDao(): MovieListDao
    abstract fun favsDao(): FavsDao
}