package com.harish.yify.data.repository

import com.harish.yify.data.Constants.COLUMN_LATEST
import com.harish.yify.data.Constants.COLUMN_POPULAR
import com.harish.yify.data.Constants.COLUMN_RATED
import com.harish.yify.data.api.YifyApi
import com.harish.yify.data.entities.FilterData
import com.harish.yify.data.entities.yify.BaseResponse
import com.harish.yify.data.entities.yify.movies.MovieListSchema
import io.reactivex.Single

class ListingCloudDataStore(private val apiClient: YifyApi) {
    fun getMoviesFromNetwork(type: String, page: Int, filters: FilterData): Single<BaseResponse<MovieListSchema>>? {
        return when (type) {
            COLUMN_LATEST -> return apiClient.getLatestMovies(page, filters.quality!!, filters.rating!!, filters.genre!!, filters.orderBy!!)
            COLUMN_POPULAR -> return apiClient.getMostPopularMovies(page, filters.quality!!, filters.rating!!, filters.genre!!, filters.orderBy!!)
            COLUMN_RATED -> return apiClient.getTopRatedMovies(page, filters.quality!!, filters.rating!!, filters.genre!!, filters.orderBy!!)
            else -> null
        }
    }
}