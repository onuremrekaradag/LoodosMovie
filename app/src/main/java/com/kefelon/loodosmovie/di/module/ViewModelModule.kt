package com.kefelon.loodosmovie.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kefelon.loodosmovie.di.ViewModelKey
import com.kefelon.loodosmovie.di.scope.AppScoped
import com.kefelon.loodosmovie.ui.main.MainViewModel
import com.kefelon.loodosmovie.ui.moviedetail.MovieDetailViewModel
import com.kefelon.loodosmovie.ui.moviesearch.SearchViewModel
import com.kefelon.loodosmovie.ui.splash.SplashScreenViewModel
import com.kefelon.loodosmovie.utils.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(SplashScreenViewModel::class)
    abstract fun bindSplashScreenViewModel(viewModel: SplashScreenViewModel): ViewModel

    @Binds
    @AppScoped
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    abstract fun bindSearchViewModel(viewModel: SearchViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailViewModel::class)
    abstract fun bindMovieDetailViewModel(viewModel: MovieDetailViewModel): ViewModel
}