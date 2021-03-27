package com.harish.yify.data.repository

import com.harish.yify.data.Constants.COLUMN_LATEST
import com.harish.yify.data.Constants.COLUMN_POPULAR
import com.harish.yify.data.Constants.COLUMN_RATED
import com.harish.yify.data.db.MovieDatabase
import com.harish.yify.data.entities.FilterData
import com.harish.yify.data.entities.db.MovieListData
import com.harish.yify.data.entities.yify.movies.MovieItemSchema
import io.reactivex.Single

class ListingLocalDataStore(private val database: MovieDatabase) {
    fun getMoviesFromCache(type: String): Single<MovieListData>? {
        return when (type) {
            COLUMN_POPULAR -> database.moviesListDao().fetchPopularMovies().onErrorReturnItem(getEmptyMovie(type))
            COLUMN_LATEST -> database.moviesListDao().fetchLatestMovies().onErrorReturnItem(getEmptyMovie(type))
            COLUMN_RATED -> database.moviesListDao().fetchTopRatedMovies().onErrorReturnItem(getEmptyMovie(type))
            else -> null
        }
    }

    fun getCachedMovie(type: String, filters: FilterData, movieListData: MovieListData): MovieListData {
        if (movieListData.filters != null && filters.toString() == movieListData.filters.toString()) {
            return movieListData
        }
        return getEmptyMovie(type)
    }

    fun updateMoviesByType(type: String, movies: MutableList<MovieItemSchema>, pageNumber: Int, filters: FilterData) {
        when (type) {
            COLUMN_POPULAR -> database.moviesListDao().updatePopularMovies(MovieListData(type,
                    pageNumber, movies, filters))
            COLUMN_LATEST -> database.moviesListDao().updateLatestMovies(MovieListData(type,
                    pageNumber, movies, filters))
            COLUMN_RATED -> database.moviesListDao().updateTopRatedMovies(MovieListData(type,
                    pageNumber, movies, filters))
        }
    }

    private fun getEmptyMovie(type: String): MovieListData = MovieListData(type, 0, ArrayList(), FilterData())
}