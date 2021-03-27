package com.harish.yify.domain.repositories

import com.harish.yify.domain.model.Detail
import com.harish.yify.domain.model.Movie
import com.harish.yify.domain.model.Omdb
import io.reactivex.Completable
import io.reactivex.Single

interface DetailsRepository {
    fun getMovie(movieId: String): Single<Detail>

    fun getOmdbDetails(movieId: String): Single<Omdb>

    fun getSuggestions(movieId: String): Single<MutableList<Movie>>

    fun isFavMovie(id: String): Single<Boolean>

    fun fav(movie: Movie): Completable

    fun unFav(movie: Movie): Completable
}
