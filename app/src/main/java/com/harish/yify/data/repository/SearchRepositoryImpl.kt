package com.harish.yify.data.repository

import com.harish.yify.data.api.YifyApi
import com.harish.yify.data.entities.MovieMapper
import com.harish.yify.domain.model.Movie
import com.harish.yify.domain.repositories.SearchRepository
import io.reactivex.Single

class SearchRepositoryImpl(private val apiClient: YifyApi, private val movieMapper: MovieMapper) : SearchRepository {

    override fun getMovies(searchTerm: String, page: Int): Single<MutableList<Movie>> = apiClient.searchMovies(page, searchTerm).map {
        movieMapper.transformMoviesFromSchema(it.data!!.movies)
    }

}