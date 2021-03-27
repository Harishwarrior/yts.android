package com.harish.yify.presentation.screens.landing.di

import com.harish.yify.presentation.di.DatabaseModule
import com.harish.yify.presentation.di.NetworkModule
import com.harish.yify.presentation.screens.moviespager.MoviesPagerComponent
import com.harish.yify.presentation.screens.moviespager.MoviesPagerModule
import com.harish.yify.presentation.screens.landing.LandingScreen
import com.harish.yify.presentation.screens.landing.di.rx.RxModule
import dagger.Subcomponent

@LandingScope
@Subcomponent(modules = [PresentationModule::class, NetworkModule::class, DatabaseModule::class, RxModule::class])
interface LandingComponent {
    operator fun plus(module: MoviesPagerModule): MoviesPagerComponent
    fun inject(target: LandingScreen)
}
