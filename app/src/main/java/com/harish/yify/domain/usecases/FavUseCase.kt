package com.harish.yify.domain.usecases

import com.harish.yify.domain.model.Movie
import com.harish.yify.domain.repositories.FavsRepository
import io.reactivex.Single

class FavUseCase(private val repository: FavsRepository) {

    fun getFavMovies(): Single<MutableList<Movie>> {
        return repository.favMovies
    }

}