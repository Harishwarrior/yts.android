package com.harish.yify.presentation.screens.listing

import com.harish.yify.data.api.YifyApi
import com.harish.yify.data.db.MovieDatabase
import com.harish.yify.data.entities.MovieMapper
import com.harish.yify.data.repository.ListingCloudDataStore
import com.harish.yify.data.repository.ListingLocalDataStore
import com.harish.yify.data.repository.ListingRepositoryImpl
import com.harish.yify.domain.repositories.ListingRepository
import com.harish.yify.domain.usecases.ListingUseCase
import com.harish.yify.presentation.common.ux.toastnotificator.ToastNotificator
import com.harish.yify.presentation.common.ux.screennavigator.ScreenNavigatorConductor
import com.harish.yify.presentation.screens.landing.di.rx.schedulers.BaseSchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class ListingModule {

    @Provides
    fun provideListingPresenter(useCase: ListingUseCase,
                                schedulerProvider: BaseSchedulerProvider,
                                filterMoviesHelper: FilterMoviesHelper,
                                screenNavigator: ScreenNavigatorConductor,
                                toastHelper: ToastNotificator): ListingContract.Presenter = ListingPresenter(useCase, schedulerProvider, filterMoviesHelper, screenNavigator, toastHelper)

    @Provides
    fun provideUseCase(repository: ListingRepository): ListingUseCase = ListingUseCase(repository)

    @Provides
    fun provideListingRepository(apiClient: YifyApi, database: MovieDatabase): ListingRepository = ListingRepositoryImpl(ListingCloudDataStore(apiClient), ListingLocalDataStore(database), MovieMapper())

}