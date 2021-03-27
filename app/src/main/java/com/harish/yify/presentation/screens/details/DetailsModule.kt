package com.harish.yify.presentation.screens.details

import com.harish.yify.data.api.OmdbApi
import com.harish.yify.data.api.YifyApi
import com.harish.yify.data.entities.DetailsMapper
import com.harish.yify.data.entities.MovieMapper
import com.harish.yify.data.repository.DetailsRepositoryImpl
import com.harish.yify.domain.repositories.DetailsRepository
import com.harish.yify.domain.repositories.FavsRepository
import com.harish.yify.domain.usecases.DetailsUseCase
import com.harish.yify.presentation.common.ux.imagepreviewer.ImagePreviewer
import com.harish.yify.presentation.common.ux.screennavigator.ScreenNavigatorConductor
import com.harish.yify.presentation.common.ux.sharemanager.ShareManager
import com.harish.yify.presentation.common.ux.toastnotificator.ToastNotificator
import com.harish.yify.presentation.common.ux.torrentmanager.TorrentManager
import com.harish.yify.presentation.common.ux.videopreviewer.VideoPreviewer
import com.harish.yify.presentation.common.ux.webviewloader.WebViewLoader
import com.harish.yify.presentation.screens.landing.di.rx.schedulers.BaseSchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class DetailsModule {
    @Provides
    fun provideDetailsPresenter(useCase: DetailsUseCase,
                                schedulerProvider: BaseSchedulerProvider,
                                tabHelper: WebViewLoader,
                                videoPreviewer: VideoPreviewer,
                                screenNavigator: ScreenNavigatorConductor,
                                imagePreviewerViewer: ImagePreviewer,
                                shareClass: ShareManager,
                                torrentOpener: TorrentManager,
                                toastHelper: ToastNotificator): DetailsContract.Presenter = DetailsPresenter(useCase, schedulerProvider, tabHelper, videoPreviewer, screenNavigator, imagePreviewerViewer, shareClass, torrentOpener, toastHelper)

    @Provides
    fun provideDetailsModel(repository: DetailsRepository): DetailsUseCase = DetailsUseCase(repository)

    @Provides
    fun provideDetailsRepository(yifyApiClient: YifyApi,
                                 omdbApiClient: OmdbApi,
                                 repository: FavsRepository): DetailsRepository = DetailsRepositoryImpl(yifyApiClient, omdbApiClient, repository, DetailsMapper(), MovieMapper())

}