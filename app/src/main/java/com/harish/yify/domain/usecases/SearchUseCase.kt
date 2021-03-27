package com.harish.yify.domain.usecases

import com.harish.yify.domain.model.Movie
import com.harish.yify.domain.repositories.SearchRepository
import io.reactivex.Single

class SearchUseCase(private var searchRepository: SearchRepository) {
    fun getMovies(searchTerm: String, page: Int): Single<MutableList<Movie>> = searchRepository.getMovies(searchTerm, page)
}