package com.harish.yify.presentation.screens.favs

import com.harish.yify.data.db.MovieDatabase
import com.harish.yify.data.entities.MovieMapper
import com.harish.yify.data.repository.FavsRepositoryImpl
import com.harish.yify.domain.repositories.FavsRepository
import com.harish.yify.domain.usecases.FavUseCase
import com.harish.yify.presentation.common.ux.screennavigator.ScreenNavigatorConductor
import com.harish.yify.presentation.screens.landing.di.rx.schedulers.BaseSchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class FavsModule {
    @Provides
    fun providesPresenter(useCase: FavUseCase,
                          schedulerProvider: BaseSchedulerProvider,
                          screenNavigator: ScreenNavigatorConductor): FavsContract.Presenter = FavsPresenter(useCase, schedulerProvider, screenNavigator)

    @Provides
    fun provideFavUseCase(repository: FavsRepository): FavUseCase = FavUseCase(repository)

    @Provides
    fun provideFavsRepository(movieDatabase: MovieDatabase): FavsRepository = FavsRepositoryImpl(movieDatabase, MovieMapper())
}
