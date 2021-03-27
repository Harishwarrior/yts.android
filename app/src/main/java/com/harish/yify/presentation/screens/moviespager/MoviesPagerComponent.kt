package com.harish.yify.presentation.screens.moviespager

import com.harish.yify.presentation.screens.about.AboutScreen
import com.harish.yify.presentation.screens.details.DetailsModule
import com.harish.yify.presentation.screens.details.DetailsScreen
import com.harish.yify.presentation.screens.favs.FavsModule
import com.harish.yify.presentation.screens.favs.FavsScreen
import com.harish.yify.presentation.screens.listing.ListingModule
import com.harish.yify.presentation.screens.listing.ListingScreen
import com.harish.yify.presentation.screens.search.SearchModule
import com.harish.yify.presentation.screens.search.SearchScreen
import dagger.Subcomponent

@MoviesPagerScope
@Subcomponent(modules = [MoviesPagerModule::class, SearchModule::class, FavsModule::class, ListingModule::class, DetailsModule::class])
interface MoviesPagerComponent {
    fun inject(target: SearchScreen)

    fun inject(target: MoviesPagerScreen)

    fun inject(target: FavsScreen)

    fun inject(target: ListingScreen)

    fun inject(target: DetailsScreen)

    fun inject(target: AboutScreen)
}