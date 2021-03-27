package com.harish.yify.domain.repositories

import com.harish.yify.domain.model.Movie
import io.reactivex.Single

interface SearchRepository {
    fun getMovies(searchTerm: String, page: Int): Single<MutableList<Movie>>
}