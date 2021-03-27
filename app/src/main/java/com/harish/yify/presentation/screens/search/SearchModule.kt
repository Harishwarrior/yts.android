package com.harish.yify.presentation.screens.search

import com.harish.yify.data.api.YifyApi
import com.harish.yify.data.entities.MovieMapper
import com.harish.yify.data.repository.SearchRepositoryImpl
import com.harish.yify.domain.repositories.SearchRepository
import com.harish.yify.domain.usecases.SearchUseCase
import com.harish.yify.presentation.common.ux.screennavigator.ScreenNavigatorConductor
import com.harish.yify.presentation.screens.landing.di.rx.schedulers.BaseSchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class SearchModule {
    @Provides
    fun providesPresenter(useCase: SearchUseCase,
                          schedulerProvider: BaseSchedulerProvider,
                          screenNavigator: ScreenNavigatorConductor): SearchContract.Presenter =
            SearchPresenter(useCase, schedulerProvider, screenNavigator)

    @Provides
    fun providesUseCase(repository: SearchRepository): SearchUseCase = SearchUseCase(repository)

    @Provides
    fun providesModel(apiClient: YifyApi): SearchRepository = SearchRepositoryImpl(apiClient, MovieMapper())
}