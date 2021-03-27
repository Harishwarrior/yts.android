package com.harish.yify.domain.usecases

import com.harish.yify.domain.model.Detail
import com.harish.yify.domain.model.Movie
import com.harish.yify.domain.model.Omdb
import com.harish.yify.domain.repositories.DetailsRepository
import io.reactivex.Single

class DetailsUseCase(private val repository: DetailsRepository) {

    fun getMovie(movieId: String): Single<Detail> = repository.getMovie(movieId)

    fun getOmdbDetails(movieId: String): Single<Omdb> = repository.getOmdbDetails(movieId)

    fun getSuggestions(movieId: String): Single<MutableList<Movie>> = repository.getSuggestions(movieId)

    fun isFavMovie(id: String): Single<Boolean> = repository.isFavMovie(id)

    fun fav(movie: Movie) = repository.fav(movie)

    fun unFav(movie: Movie) = repository.unFav(movie)

}